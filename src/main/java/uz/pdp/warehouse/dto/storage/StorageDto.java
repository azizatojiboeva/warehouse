package uz.pdp.warehouse.dto.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.entity.product.Product;

import java.util.List;

@Getter
@Setter
public class StorageDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private Long organization_id;

    private List<Product> products;

    public StorageDto(Long id, String name, Double latitude, Double longitude, Long organization_id, List<Product> products) {
        super(id);
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.organization_id = organization_id;
        this.products = products;
    }
}
