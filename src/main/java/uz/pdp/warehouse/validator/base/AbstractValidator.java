package uz.pdp.warehouse.validator.base;

import uz.pdp.warehouse.exception.validation.ValidationException;

public abstract class AbstractValidator<CD, UD, K> implements BaseGenericValidator {

    public abstract void validateKey(K id) throws
            ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


}