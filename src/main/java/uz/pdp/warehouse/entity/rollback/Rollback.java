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
    private Product rollBackedProductId;

    @Column(nullable = false)
    private Integer productCount;

    @Column(nullable = false)
    private Double amountMoney;

    @Column(nullable = false)
    private Long marketId;

    @ManyToOne
    private Transaction oldTransaction;

    @ManyToOne
    private Transaction newTransaction;

}
