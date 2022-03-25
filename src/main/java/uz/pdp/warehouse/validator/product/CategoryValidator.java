package uz.pdp.warehouse.validator.product;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Component
public class CategoryValidator extends AbstractValidator<CategoryCreateDto, CategoryUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id) || id < 0) {
            throw new ValidationException("INVALID_ID");
        }
    }


    @Override
    public void validOnCreate(CategoryCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.code)) {
            throw new ValidationException("INVALID_CODE");
        } else if (Objects.isNull(createDto.name)) {
            throw new ValidationException("INVALID_NAME");
        }
    }

    @Override
    public void validOnUpdate(CategoryUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto.code)) {
            throw new ValidationException("INVALID_CODE");
        } else if (Objects.isNull(updateDto.name)) {
            throw new ValidationException("INVALID_NAME");
        }
    }
}
