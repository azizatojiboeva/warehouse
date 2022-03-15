package uz.pdp.warehouse.entity.storage;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.product.Product;
import java.util.List;
import javax.persistence.*;


@Entity
@Setter
@Getter
public class Storage extends Auditable {

    private String name;

    private Double latitude;

    private Double longitude;

    @Column(nullable = false)
    private Long organization_id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;

}
