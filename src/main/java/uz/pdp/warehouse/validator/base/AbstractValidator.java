package uz.pdp.warehouse.validator.base;

import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.exception.validation.ValidationException;

import java.util.List;
import java.util.Optional;

public abstract class AbstractValidator<CD, UD, K> implements BaseGenericValidator {

    public abstract void validateKey(K id) throws
            ValidationException;

    public abstract void validOnCreate(CD createDto) throws ValidationException;

    public abstract void validOnUpdate(UD updateDto) throws ValidationException;

}