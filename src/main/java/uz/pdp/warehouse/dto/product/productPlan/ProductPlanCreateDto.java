package uz.pdp.warehouse.dto.product.productPlan;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.product.product.ProductForPlanDto;
import uz.pdp.warehouse.entity.product.Product;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Setter
@Getter
public class ProductPlanCreateDto implements BaseGenericDto {

    public Long agentId;

    public ProductForPlanDto product;

    public Integer count;

    public LocalDate period;


}
