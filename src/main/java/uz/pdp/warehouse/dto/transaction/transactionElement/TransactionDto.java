package uz.pdp.warehouse.dto.transaction.transactionElement;

import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.enums.CashType;

import java.util.List;

public class TransactionDto extends GenericDto {
    public Long marketId;

    public Double totalMoney;

    public Double paidMoney;

    public String cashType;

    public List<TransactionElementDto> elements;

    public TransactionDto(Long id) {
        super(id);
    }
}
