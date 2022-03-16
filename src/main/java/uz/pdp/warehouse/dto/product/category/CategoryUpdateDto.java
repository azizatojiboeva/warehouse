package uz.pdp.warehouse.dto.product.category;

import lombok.*;
import uz.pdp.warehouse.dto.base.GenericDto;

@Setter
@Getter
public class CategoryUpdateDto extends GenericDto {
    public String name;

    public String code;

    @Builder(builderMethodName = "childBuilder")
    public CategoryUpdateDto(Long id, String name, String code) {
        super(id);
        this.name = name;
        this.code = code;
    }
}
