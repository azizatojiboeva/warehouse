package uz.pdp.warehouse.entity.transaction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.product.Product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class TransactionElement extends Auditable {

    private Long productId;

    private Integer count;

    private Double price;

    private Double totalPrice;

    private Long transactionId;
}
