package uz.pdp.warehouse.entity.storage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.product.Product;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Setter
@Getter
public class Storage extends Auditable {

    private String name;

    private Double latitude;

    private Double longitude;



}
