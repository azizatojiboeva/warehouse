package uz.pdp.warehouse.dto.transaction.transactionElement;

import uz.pdp.warehouse.dto.base.GenericDto;

public class TransactionElementDto extends GenericDto {
    public Long productId;

    public Integer count;

    public Double price;

    public Double totalPrice;

    public Long transactionId;

    public TransactionElementDto(Long id) {
        super(id);
    }
}
