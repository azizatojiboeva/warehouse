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
public class ProductPlanUpdateDto extends GenericDto {

    public Long agentId;

    public Product product;

    public Integer count;

    public LocalDate period;

    @Builder
    public ProductPlanUpdateDto(Long id) {
        super(id);
    }
}
