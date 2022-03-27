package uz.pdp.warehouse.dto.product.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class ProductDto extends GenericDto {

    public String name;
    public String description;
    public Double initialPrice;
    public Double sellingPrice;
    public Integer softCount;
    public Integer realCount;
    public String madeBy;
    public LocalDate expiryDate;
    public LocalDate producedDate;
    public List<CategoryDto> category;
    public UUID partyNumber;

    @Builder(builderMethodName = "childBuilder")

    public ProductDto(Long id, String name, String description, Double initialPrice, Double sellingPrice, Integer softCount, Integer realCount, String madeBy, LocalDate expiryDate, LocalDate producedDate, List<CategoryDto> category, UUID partyNumber) {
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
        this.partyNumber = partyNumber;
    }
}
