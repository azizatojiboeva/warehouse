package uz.pdp.warehouse.entity.transaction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.enums.CashType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Transaction extends Auditable {

    private Long marketId;

    private Double totalMoney; // to'lanishi kerak bo'lgan summa

    private Double paidMoney; // to'langan summa

    @Enumerated(EnumType.ORDINAL)
    private CashType cashType;

    @OneToMany(mappedBy = "transactionId", fetch = FetchType.LAZY)
    private List<TransactionElement> elements;


}
