package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import java.util.List;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "category",schema = "product")
public class Category extends Auditable {

    private String name;

    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

//    @OneToMany(mappedBy = "product")   Hamma category larga tegishli product larni ko'tarib yurmaslik uchun
//    private List<Product> product;


}
