package uz.pdp.warehouse.dto.product.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.entity.product.Category;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ProductUpdateDto extends GenericDto {
    private String name;
    private String description;
    private Double initialPrice;
    private Double sellingPrice;
    private Integer softCount;
    private Integer realCount;
    private String madeBy;
    private LocalDate expiryDate;
    private LocalDate producedDate;
    private List<CategoryDto> category;

    @Builder(builderMethodName = "childBuilder")

    public ProductUpdateDto(Long id, String name, String description, Double initialPrice, Double sellingPrice, Integer softCount, Integer realCount, String madeBy, LocalDate expiryDate, LocalDate producedDate, List<CategoryDto> category) {
        super(id);
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.sellingPrice = sellingPrice;
        this.softCount = softCount;
        this.realCount = realCount;
        this.madeBy = madeBy;
        this.expiryDate = expiryDate;
        this.producedDate = producedDate;
        this.category = category;
    }
}
