package uz.pdp.warehouse.dto.product.category;

import lombok.*;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto implements BaseGenericDto {
    public String name;

    public String code;

}
