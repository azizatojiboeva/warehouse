package uz.pdp.warehouse.entity.product;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.storage.Storage;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "product",schema = "product")
public class Product extends Auditable {

    private String name;

    private String description;

    private Double initialPrice;

    private Double sellingPrice;

    private Integer softCount;

    private Integer realCount;

    private String madeBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToOne(mappedBy = "product")
    private ProductPlan productPlan;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    private LocalDateTime expiryDate;

//    private JSONPObject attribute;

}
