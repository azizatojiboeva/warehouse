package uz.pdp.warehouse.dto.product.productPlan;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.product.product.ProductForPlanDto;
import uz.pdp.warehouse.entity.product.Product;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class ProductPlanCreateDto implements BaseGenericDto {

    @NotNull
    @Positive
    public Long agentId;

    @NotNull
    public ProductForPlanDto product;

    @NotNull
    @PositiveOrZero
    public Integer count;

    @NotNull
    public LocalDate period;

}
