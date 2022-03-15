package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class ProductPlan extends Auditable {

    private Long agentId;

    @OneToOne
    private Product products;

    private Integer count;

    private LocalDate period;

}

