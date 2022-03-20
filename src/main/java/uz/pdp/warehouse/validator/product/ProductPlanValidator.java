package uz.pdp.warehouse.validator.product;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Component
public class ProductPlanValidator extends AbstractValidator<ProductPlanCreateDto, ProductPlanUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id)) {
            throw new ValidationException("ID_IS_NULL");
        }
    }

    @Override
    public void validOnCreate(ProductPlanCreateDto productPlanCreateDto) throws ValidationException {
        if (Objects.isNull(productPlanCreateDto.agentId)) {
            throw new ValidationException("ID_IS_NULL");
        }
    }

    @Override
    public void validOnUpdate(ProductPlanUpdateDto productPlanUpdateDto) throws ValidationException {

    }
}
