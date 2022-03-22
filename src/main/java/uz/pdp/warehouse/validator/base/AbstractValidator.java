package uz.pdp.warehouse.validator.base;

import uz.pdp.warehouse.exception.validation.ValidationException;

public abstract class AbstractValidator<CD, UD, K> implements BaseGenericValidator {

    public abstract void validateKey(K id) throws
            ValidationException;

    public abstract void validOnCreate(CD createDto) throws ValidationException;

    public abstract void validOnUpdate(UD updateDto) throws ValidationException;

}