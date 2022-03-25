package uz.pdp.warehouse.dto.transaction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
public class TransactionUpdateDto extends GenericDto {
    public Long marketId;

    public Double totalMoney;

    public Double paidMoney;

    public String cashType;

    public TransactionUpdateDto(Long id) {
        super(id);
    }
}
