package uz.pdp.warehouse.dto.transaction.transactionElement;

import uz.pdp.warehouse.dto.base.BaseGenericDto;

public class TransactionElementCreateDto implements BaseGenericDto {

    public Long productId;

    public Integer count;

    public Double price;

    public Long transactionId;
}
