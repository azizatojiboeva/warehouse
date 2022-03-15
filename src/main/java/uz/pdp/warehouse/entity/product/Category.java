package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "category",schema = "product")
public class Category extends Auditable {

    private String name;

    private String code;

    @OneToOne(mappedBy = "product")
    private Product product;


}
