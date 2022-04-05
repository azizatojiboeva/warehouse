package uz.pdp.warehouse.validator.rollBack;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.rollBack.RollBackCreateDto;
import uz.pdp.warehouse.dto.rollBack.RollBackUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Component
public class RollBackValidator extends AbstractValidator<RollBackCreateDto, RollBackUpdateDto, Long> {
    @Override
    public void validateKey(Long id) {
        validateKey(id, "");
    }

    public void validateKey(Long id, String target) throws ValidationException {
        if (Objects.isNull(id) || isNegative((double) id)) {
            throw new ValidationException("INVALID_" + target + "ID");
        }
    }

    @Override
    public void validOnCreate(RollBackCreateDto createDto) throws ValidationException {
        validateKey(createDto.market_id, "MARKET_");
        validateKey(createDto.rollBackedProductId.id, "PRODUCT_");
        validateKey(createDto.transactionId.id, "TRANSACTION_");
        if (Objects.isNull(createDto.amountOfMoney) || isNegative(createDto.amountOfMoney)) {
            throw new ValidationException("INVALID_AMOUNT");
        } else if (Objects.isNull(createDto.rollBackedCount) || isNegative((double) createDto.rollBackedCount)) {
            throw new ValidationException("INVALID_PRODUCT_COUNT");
        }
    }

    @Override
    public void validOnUpdate(RollBackUpdateDto updateDto) throws ValidationException {
        validateKey(updateDto.marketId, "MARKET_");
        validateKey(updateDto.rollBackedProductId.id, "PRODUCT_");
        validateKey(updateDto.oldTransaction.id, "TRANSACTION_");
        validateKey(updateDto.newTransaction.id, "TRANSACTION_");
        if (Objects.isNull(updateDto.amountMoney) || isNegative(updateDto.amountMoney)) {
            throw new ValidationException("INVALID_AMOUNT");
        } else if (Objects.isNull(updateDto.productCount) || isNegative((double) updateDto.productCount)) {
            throw new ValidationException("INVALID_PRODUCT_COUNT");
        }
    }
}
