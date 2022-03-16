package uz.pdp.warehouse.dto.product.category;

import lombok.*;
import uz.pdp.warehouse.dto.base.GenericDto;

@Setter
@Getter
public class CategoryDto extends GenericDto {

    public String name;

    public String code;

    @Builder(builderMethodName = "childBuilder")
    public CategoryDto(Long id, String name, String code) {
        super(id);
        this.name = name;
        this.code = code;
    }
}
