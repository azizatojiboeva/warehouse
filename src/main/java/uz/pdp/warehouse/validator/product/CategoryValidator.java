package uz.pdp.warehouse.validator.product;

import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

public class CategoryValidator extends AbstractValidator<CategoryCreateDto, CategoryUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CategoryCreateDto categoryCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CategoryUpdateDto cd) throws ValidationException {

    }
}
