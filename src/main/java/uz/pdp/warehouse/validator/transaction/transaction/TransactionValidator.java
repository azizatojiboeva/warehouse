package uz.pdp.warehouse.validator.transaction.transaction;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.enums.CashType;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Arrays;
import java.util.Objects;

@Service
public class TransactionValidator extends AbstractValidator<TransactionCreateDto, TransactionUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id) || id < 0) {
            throw new ValidationException("INVALID_ID");
        }
    }

    @Override
    public void validOnCreate(TransactionCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto) ||
                Arrays.stream(CashType.values())
                        .anyMatch(cashType -> cashType.toString().equals(createDto.cashType.toUpperCase()))) {
            throw new ValidationException("INVALID_CASH_TYPE");
        } else if (Objects.isNull(createDto.marketId) || createDto.marketId < 0) {
            throw new ValidationException("INVALID_MARKET_ID");
        }
    }

    @Override
    public void validOnUpdate(TransactionUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto) ||
                Arrays.stream(CashType.values())
                        .anyMatch(cashType -> cashType.toString().equals(updateDto.cashType.toUpperCase()))) {
            throw new ValidationException("INVALID_CASH_TYPE");
        } else if (Objects.isNull(updateDto.marketId) || updateDto.marketId < 0) {
            throw new ValidationException("INVALID_MARKET_ID");
        } else if (Objects.isNull(updateDto.paidMoney) || updateDto.paidMoney < 0) {
            throw new ValidationException("INVALID_PAID_MONEY");
        } else if (Objects.isNull(updateDto.totalMoney) || updateDto.totalMoney < 0) {
            throw new ValidationException("INVALID_TOTAL_MONEY");
        }
    }
}
