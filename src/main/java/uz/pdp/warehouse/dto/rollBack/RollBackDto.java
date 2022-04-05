package uz.pdp.warehouse.dto.rollBack;

import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;

public class RollBackDto extends GenericDto {
    private ProductDto rollBackedProductId;

    private Integer rollBackedCount;

    private ProductDto givenProductId;

    private Integer givenCount;

    private Long market_id;

    private TransactionDto transactionId;


    public RollBackDto(Long id) {
        super(id);
    }
}
