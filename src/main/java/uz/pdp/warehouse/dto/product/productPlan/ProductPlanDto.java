package uz.pdp.warehouse.dto.product.productPlan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
@Setter
@Getter
public class ProductPlanDto extends GenericDto {
    @Builder
    public ProductPlanDto(Long id) {
        super(id);
    }
}
