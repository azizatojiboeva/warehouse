package uz.pdp.warehouse.entity.rollback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.transaction.Transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rollback extends Auditable {

    @ManyToOne
    private Product rollbackedProductId;

    @Column(nullable = false)
    private Integer rollbackedCount;

    @ManyToOne
    private Product givedProductId;

    @Column(nullable = false)
    private Integer givedCount;

    @Column(nullable = false)
    private Long market_id;

    @ManyToOne
    private Transaction transactionId;




}
