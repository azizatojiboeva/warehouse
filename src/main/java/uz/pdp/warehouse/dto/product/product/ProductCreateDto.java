package uz.pdp.warehouse.dto.product.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ProductCreateDto implements BaseGenericDto {

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

}
