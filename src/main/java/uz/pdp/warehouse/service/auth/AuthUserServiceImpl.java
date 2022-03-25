package uz.pdp.warehouse.service.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.config.encryption.PasswordEncoderConfigurer;
import uz.pdp.warehouse.criteria.auth.user.UserCriteria;
import uz.pdp.warehouse.dto.auth.*;
import uz.pdp.warehouse.entity.auth.AuthRole;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.exception.UserNotFoundException;
import uz.pdp.warehouse.mapper.auth.AuthUserMapper;
import uz.pdp.warehouse.repository.auth.AuthRoleRepository;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.auth.AuthUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class AuthUserServiceImpl extends
        AbstractService<
                AuthUserRepository,
                AuthUserMapper,
                AuthUserValidator>
        implements AuthUserService, UserDetailsService {

    private final PasswordEncoderConfigurer passwordEncoder;
    private final AuthRoleRepository authRoleRepository;
    private final ObjectMapper objectMapper;

    protected AuthUserServiceImpl(
            AuthUserMapper mapper,
            AuthUserValidator validator,
            AuthUserRepository repository,
            PasswordEncoderConfigurer passwordEncoder, AuthRoleRepository authRoleRepository, ObjectMapper objectMapper) {
        super(mapper, validator, repository);
        this.passwordEncoder = passwordEncoder;
        this.authRoleRepository = authRoleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(UserCreateDto createDto) {
        // TODO: 3/18/2022 there should be validation, checks if this user already exist in database, have all required fields

        AuthRole user = authRoleRepository.findByCode("USER");
        AuthUser authUser = mapper.fromCreateDto(createDto);
        authUser.setPassword(passwordEncoder.passwordEncoder().encode(createDto.getPassword()));
        authUser.setRole(user);
        repository.save(authUser);
        return new ResponseEntity<>(new DataDto<>(authUser.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        Optional<AuthUser> user = repository.findById(id);
        if(user.isEmpty()){
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "user not found")));
        }
        repository.softDelete(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(UserUpdateDto updateDto) {
        Optional<AuthUser> user = repository.findById(updateDto.getId());
        if(user.isEmpty()){
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "user not found")));
        }
        AuthUser authUser = user.get();
        authUser.setPhoneNumber(updateDto.getPhoneNumber());
        authUser.setEmail(updateDto.getEmail());
        authUser.setFullName(updateDto.getFullName());
        repository.save(authUser);
        return new ResponseEntity<>(new DataDto<>(true));
    }

    @Override
    public ResponseEntity<DataDto<UserDto>> get(Long id) {
        AuthUser authUser = repository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("User not found");
        });
        UserDto userDto = mapper.toDto(authUser);
        userDto.setAuthRole(authUser.getRole());
        return new ResponseEntity<>(new DataDto<>(userDto));
    }

    @Override
    public ResponseEntity<DataDto<List<UserDto>>> getAll(UserCriteria criteria) {
        return null;
    }


    @Override
    public ResponseEntity<DataDto<List<UserDto>>> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<AuthUser> authUsers = repository.findAll();
        for (AuthUser authUser : authUsers) {
            if (!authUser.isDeleted()) {
                UserDto userDto = mapper.toDto(authUser);
                userDto.setAuthRole(authUser.getRole());
                userDtos.add(userDto);
            }
        }
        return new ResponseEntity<>(new DataDto<>(userDtos));
    }

    public ResponseEntity<DataDto<Void>> resetPassword(PasswordDto dto) {
        Optional<AuthUser> user = repository.findById(dto.getId());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        if (!dto.getOldPass().equalsIgnoreCase(dto.getNewPassword())) {
            throw new RuntimeException("Password doesn't match.");
        }
        repository.resetPassword(passwordEncoder.passwordEncoder().encode(dto.getNewPassword()), dto.getId());
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthUser user = repository.findByEmail(email);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .credentialsExpired(false)
                .accountExpired(false)
                .accountLocked(false)
                .disabled(false)
                .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                .build();
    }

    public ResponseEntity<DataDto<SessionDto>> getToken(LoginDto dto) {
        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost("http://localhost:8080" + "/api/login");
            byte[] bytes = objectMapper.writeValueAsBytes(dto);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setEntity(new InputStreamEntity(byteArrayInputStream));

            HttpResponse response = client.execute(httppost);

            JsonNode json_auth = objectMapper.readTree(EntityUtils.toString(response.getEntity()));

            if (json_auth.has("success") && json_auth.get("success").asBoolean()) {
                JsonNode node = json_auth.get("data");
                SessionDto sessionDto = objectMapper.readValue(node.toString(), SessionDto.class);
                return new ResponseEntity<>(new DataDto<>(sessionDto));
            }
            return new ResponseEntity<>(
                    new DataDto<>(objectMapper.readValue(json_auth.get("error").toString(), AppErrorDto.class)));

        } catch (IOException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build()), HttpStatus.OK);
        }
    }

    public ResponseEntity<DataDto<SessionDto>> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
