package uz.pdp.warehouse.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.auth.PasswordDto;
import uz.pdp.warehouse.dto.auth.UserCreateDto;
import uz.pdp.warehouse.dto.auth.UserDto;
import uz.pdp.warehouse.dto.auth.UserUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserServiceImpl;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@RestController
@RequestMapping(value = "/api/auth")
public class AuthUserController extends AbstractController<AuthUserServiceImpl> {


    public AuthUserController(AuthUserServiceImpl service) {
        super(service);
    }

    @GetMapping("")
    @PreAuthorize(value = "hasPermission('hasAccess','ALL_USERS')")
    public ResponseEntity<DataDto<List<UserDto>>> getAll() {
        ResponseEntity<DataDto<List<UserDto>>> users = service.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDto<UserDto>> getUserById(@PathVariable(name = "id") Long id) {
        ResponseEntity<DataDto<UserDto>> entity = service.get(id);
        return entity;
    }


    @PutMapping("/{id}")
    @PreAuthorize(value = "hasPermission('hasAccess', 'USER_UPDATE')")
    public ResponseEntity<DataDto<Boolean>> update(@PathVariable(name = "id") Long id,
                                                   @RequestBody UserUpdateDto dto) {
        dto.setId(id);
        ResponseEntity<DataDto<Boolean>> response = service.update(dto);
        return response;
    }

    @PutMapping("/resetPassword/{id}")
    public ResponseEntity<DataDto<Void>> resetPassword(@PathVariable(name = "id") long id,
                                                       @RequestBody PasswordDto dto) {
        dto.setId(id);
        service.resetPassword(dto);
        return new ResponseEntity<>(new DataDto<>(null), HttpStatus.OK);
    }


    @PostMapping("")
    @PreAuthorize(value = "hasPermission('hasAccess', 'USER_CREATE')")
    public ResponseEntity<DataDto<Long>> create(@Valid @RequestBody UserCreateDto createDto) {
        return service.create(createDto);
    }


    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ResponseEntity<DataDto<Boolean>> verifyUser(@RequestParam(name = "email") String email) {
        return service.verify(email);
    }

    @RequestMapping(value = "/sendVerification", method = RequestMethod.GET)
    public ResponseEntity<DataDto<Boolean>> sendVerificationCode(@RequestParam(name = "email") String email,
                                                                 @RequestParam(name = "url") String url) {

                                                                 @RequestParam(name = "url") String url){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(new DataDto<>(null), HttpStatus.OK);
    }

    //-----------------------  new method  ---------------------------//

    @GetMapping(value = "/add/{id}")
    public ResponseEntity<DataDto<Void>> addUser(@PathVariable(name = "id") Long id) {
        return service.addUser(id);
    }

    @GetMapping(value = "/accept/{code}")
    public ResponseEntity<DataDto<Boolean>> accept(@PathVariable(name = "code") String code) {

        return service.accept(code);
    }


}
