package uz.pdp.warehouse.entity.product;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "product", schema = "product")
public class Product extends Auditable {

    private String name;

    private String description;

    private Double initialPrice;

    private Double sellingPrice;

    private Integer softCount;

    private Integer realCount;

    private String madeBy;

    private LocalDate expiryDate;

    private LocalDate producedDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private List<Category> category;

}
