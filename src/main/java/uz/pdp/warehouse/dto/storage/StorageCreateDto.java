package uz.pdp.warehouse.dto.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.entity.product.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StorageCreateDto implements BaseGenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private Long organization_id;

    private List<Product> products;

}
