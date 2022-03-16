package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "category", schema = "product")
public class Category extends Auditable {

    private String name;

    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @OneToOne(mappedBy = "category")
    private Product product;


}
