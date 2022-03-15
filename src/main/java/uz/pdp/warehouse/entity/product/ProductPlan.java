package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class ProductPlan extends Auditable {

    private Long agentId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    private Integer count;

    private LocalDate period;

}

