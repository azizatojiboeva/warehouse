package uz.pdp.warehouse.dto.product.productPlan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

@Setter
@Getter
public class ProductPlanUpdateDto extends GenericDto {
@Builder
    public ProductPlanUpdateDto(Long id) {
        super(id);
    }
}
