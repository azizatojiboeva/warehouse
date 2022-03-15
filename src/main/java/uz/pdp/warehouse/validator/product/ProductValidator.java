package uz.pdp.warehouse.validator.product;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

@Component
public class ProductValidator extends AbstractValidator<ProductCreateDto, ProductUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProductCreateDto productCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProductUpdateDto cd) throws ValidationException {

    }
}
