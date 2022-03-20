package uz.pdp.warehouse.dto.product.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProductForPlanDto extends GenericDto {

    public String name;
    public String madeBy;
    public String description;
    public Double sellingPrice;
    public LocalDate expiryDate;
    public LocalDate producedDate;
    public List<CategoryDto> category;

    public ProductForPlanDto(Long id,
                             String name,
                             String madeBy,
                             String description,
                             Double sellingPrice,
                             LocalDate expiryDate,
                             LocalDate producedDate,
                             List<CategoryDto> category) {
        super(id);
        this.name = name;
        this.madeBy = madeBy;
        this.category = category;
        this.expiryDate = expiryDate;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.producedDate = producedDate;
    }
}


