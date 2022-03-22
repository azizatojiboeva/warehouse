package uz.pdp.warehouse.dto.transaction.transactionElement;

import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.base.GenericDto;

public class TransactionElementUpdateDto extends GenericDto {

    public Long productId;

    public Integer count;

    public Double price;

    public Double totalPrice;

    public Long transactionId;

    public TransactionElementUpdateDto(Long id) {
        super(id);
    }
}
