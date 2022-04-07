package uz.pdp.warehouse.utils.annotation;

import lombok.RequiredArgsConstructor;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @Author Aziza Tojiboyeva
 */
@RequiredArgsConstructor
public class UniqueAnnotation implements ConstraintValidator<Unique, String> {
    private UniqueType type;
    private final AuthUserRepository repository;


    @Override
    public void initialize(Unique unique) {
        this.type = unique.type();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return switch (type) {
            case EMAIL -> validEmail(value);
            case PHONENUMBER -> validPhone(value);
            case DEFAULT -> true;
        };
    }

    private boolean validPhone(String value) {
        AuthUser byPhoneNumber = repository.findByPhoneNumber(value);
        return Objects.isNull(byPhoneNumber);
    }

    private boolean validEmail(String value) {
        AuthUser byEmail = repository.findByEmail(value);
        return Objects.isNull(byEmail);
    }


}
