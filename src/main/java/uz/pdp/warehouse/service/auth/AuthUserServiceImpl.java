package uz.pdp.warehouse.service.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.auth.PasswordDto;
import uz.pdp.warehouse.dto.auth.UserCreateDto;
import uz.pdp.warehouse.dto.auth.UserDto;
import uz.pdp.warehouse.dto.auth.UserUpdateDto;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.exception.UserNotFoundException;
import uz.pdp.warehouse.mapper.auth.AuthUserMapper;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.auth.AuthUserValidator;

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

    private final PasswordEncoder passwordEncoder;

    protected AuthUserServiceImpl(
            AuthUserMapper mapper,
            AuthUserValidator validator,
            AuthUserRepository repository, PasswordEncoder passwordEncoder) {
        super(mapper, validator, repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(UserCreateDto createDto) {
        repository.save(mapper.fromCreateDto(createDto));
        return new ResponseEntity<>(new DataDto<>());
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        repository.softDelete(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(UserUpdateDto updateDto) {
        AuthUser authUser = mapper.fromUpdateDto(updateDto);
        repository.save(authUser);
        return new ResponseEntity<>(new DataDto<>(true));
    }

    @Override
    public ResponseEntity<DataDto<UserDto>> get(Long id) {
        AuthUser authUser = repository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("User not found");
        });
        return new ResponseEntity<>(new DataDto<>(mapper.toDto(authUser)));
    }

    @Override
    public ResponseEntity<DataDto<List<UserDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<UserDto>>> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        List<AuthUser> authUsers = repository.findAll();
        for (AuthUser authUser : authUsers) {
            if (!authUser.isDeleted()) {
                userDtos.add(mapper.toDto(authUser));
            }
        }
        return new ResponseEntity<>(new DataDto<>(userDtos));
    }

    public ResponseEntity<DataDto<Void>> resetPassword(PasswordDto dto) {
        Optional<AuthUser> user = repository.findById(dto.getId());
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        if(!dto.getOldPass().equalsIgnoreCase(dto.getNewPassword())){
            throw new RuntimeException("Password doesn't match.");
        }
        repository.resetPassword(passwordEncoder.encode(dto.getNewPassword()),dto.getId() );
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthUser user = repository.findByEmail(email);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                .build();
    }
}
