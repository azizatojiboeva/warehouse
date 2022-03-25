package uz.pdp.warehouse.validator.product;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Component
public class ProductValidator extends AbstractValidator<ProductCreateDto, ProductUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProductCreateDto productCreateDto) throws ValidationException {

        if (Objects.isNull(productCreateDto.getName()) || Objects.isNull(productCreateDto.getInitialPrice())
                || Objects.isNull(productCreateDto.getSellingPrice()) || Objects.isNull(productCreateDto.getSoftCount())
                || Objects.isNull(productCreateDto.getRealCount()) || Objects.isNull(productCreateDto.getCategory())) {
            throw new ValidationException("SOMETHING_WENT_WRONG");
        }

    }

    @Override
    public void validOnUpdate(ProductUpdateDto productUpdateDto) throws ValidationException {

        if (Objects.isNull(productUpdateDto.getName()) || Objects.isNull(productUpdateDto.getId()) || Objects.isNull(productUpdateDto.getInitialPrice())
                || Objects.isNull(productUpdateDto.getSellingPrice()) || Objects.isNull(productUpdateDto.getSoftCount())
                || Objects.isNull(productUpdateDto.getRealCount()) || Objects.isNull(productUpdateDto.getCategory())) {
            throw new ValidationException("SOMETHING_WENT_WRONG");
        }

    }
}
