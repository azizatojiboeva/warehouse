package uz.pdp.warehouse.entity.product;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class ProductPlan extends Auditable {

    private Long agentId;




    private Integer count;

    private LocalDate period;

}
