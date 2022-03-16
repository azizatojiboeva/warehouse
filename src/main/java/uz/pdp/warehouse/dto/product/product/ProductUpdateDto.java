package uz.pdp.warehouse.dto.product.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

@Setter
@Getter
public class ProductUpdateDto extends GenericDto {
    @Builder
    public ProductUpdateDto(Long id) {
        super(id);
    }
}
