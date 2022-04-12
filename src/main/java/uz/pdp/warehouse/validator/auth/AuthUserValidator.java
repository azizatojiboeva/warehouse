package uz.pdp.warehouse.validator.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.auth.UserCreateDto;
import uz.pdp.warehouse.dto.auth.UserUpdateDto;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
@RequiredArgsConstructor
public class AuthUserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, Long> {

    private final AuthUserRepository repository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        repository.findById(id).orElseThrow(() -> {
            throw new ValidationException("Not valid id!");
        });
    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }

    public void validateCode(String code) {
        if (code.length() < 5) {
            throw new ValidationException("INVALID_CODE");
        }
    }

    public void validateUser(Optional<AuthUser> user) {
        if (user.isEmpty()) {
            throw new ValidationException("USER_NOT_FOUND");
        }
    }
}
