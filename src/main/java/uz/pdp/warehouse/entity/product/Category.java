package uz.pdp.warehouse.entity.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "category")
public class Category extends Auditable {

    private String name;

    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

//    @OneToMany(mappedBy = "product")   Hamma category larga tegishli product larni ko'tarib yurmaslik uchun
//    private List<Product> product;


    @Builder(builderMethodName = "childBuilder")
    public Category(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt,
                    LocalDateTime updatedAt, boolean deleted, boolean blocked, boolean active, String name, String code, Category parentCategory) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted, blocked, active);
        this.name = name;
        this.code = code;
        this.parentCategory = parentCategory;
    }

    public Category() {

    }
}
