package uz.pdp.warehouse.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.auth.*;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserServiceImpl;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@RestController(value = "/api/auth/*")
public class AuthUserController extends AbstractController<AuthUserServiceImpl> {


    public AuthUserController(AuthUserServiceImpl service) {
        super(service);
    }

    @GetMapping("")
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
    public ResponseEntity<DataDto<Boolean>> update(@PathVariable(name = "id") Long id,
                                                   @RequestBody UserUpdateDto dto) {
        dto.setId(id);
        ResponseEntity<DataDto<Boolean>> response = service.update(dto);
        return response;
    }

    @PutMapping("resetPassword/{id}")
    public ResponseEntity<DataDto<Void>> resetPassword(@PathVariable(name = "id") long id,
                                                       @RequestBody PasswordDto dto) {
        dto.setId(id);
        service.resetPassword(dto);
        return new ResponseEntity<>(new DataDto<>(null), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DataDto<Long>> create(@RequestBody UserCreateDto createDto) {
        ResponseEntity<DataDto<Long>> response = service.create(createDto);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(new DataDto<>(null), HttpStatus.OK);
    }








}
