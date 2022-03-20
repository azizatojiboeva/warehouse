package uz.pdp.warehouse.dto.product.productPlan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.entity.product.Product;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Setter
@Getter
public class ProductPlanDto extends GenericDto {
    @Builder
    public ProductPlanDto(Long id) {
        super(id);
    }

    private Long agentId;

    @OneToOne
    private Product products;

    private Integer count;

    private LocalDate period;

}
