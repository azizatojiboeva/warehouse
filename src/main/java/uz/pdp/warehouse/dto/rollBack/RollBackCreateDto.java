package uz.pdp.warehouse.dto.rollBack;

import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.product.product.ProductForPlanDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;

public class RollBackCreateDto implements BaseGenericDto {

    public ProductForPlanDto rollBackedProductId;

    public Integer rollBackedCount;

    public Long market_id;

    public Double amountOfMoney;

    public TransactionDto transactionId;
}
