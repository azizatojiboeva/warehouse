package uz.pdp.warehouse.entity.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class ProductPlan extends Auditable {

    private Long agentId;

    @OneToOne
    private Product products;

    private Integer count;

    private LocalDate period;

    @Builder(builderMethodName = "childBuilder")
    public ProductPlan(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt,
                       LocalDateTime updatedAt, boolean deleted, boolean blocked, boolean active, Long agentId,
                       Product products, Integer count, LocalDate period) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted, blocked,active );
        this.agentId = agentId;
        this.products = products;
        this.count = count;
        this.period = period;
    }


}

