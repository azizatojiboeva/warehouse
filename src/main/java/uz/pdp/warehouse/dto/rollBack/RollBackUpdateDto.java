package uz.pdp.warehouse.dto.rollBack;

import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductForPlanDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;

public class RollBackUpdateDto extends GenericDto {

    public ProductForPlanDto rollBackedProductId;

    public Integer productCount;

    public Double amountMoney;

    public Long marketId;

    public TransactionDto oldTransaction;

    public TransactionDto newTransaction;

    public RollBackUpdateDto(Long id) {
        super(id);
    }
}
