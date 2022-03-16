package uz.pdp.warehouse.dto.product.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
@Setter
@Getter
public class ProductDto extends GenericDto {
    @Builder
    public ProductDto(Long id) {
        super(id);
    }
}
