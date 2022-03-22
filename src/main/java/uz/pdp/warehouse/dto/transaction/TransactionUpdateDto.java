package uz.pdp.warehouse.dto.transaction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.enums.CashType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class TransactionUpdateDto extends GenericDto {
    public Long marketId;

    public Double totalMoney;

    public Double paidMoney;

    public String cashType;

    public TransactionUpdateDto(Long id) {
        super(id);
    }
}
