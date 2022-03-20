package uz.pdp.warehouse.dto.product.category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SubCategoryCreateDto {

    @NotNull
    @Positive
    public Long parentCategory;

    @NotNull
    public String name;

    @NotNull
    public String code;

}
