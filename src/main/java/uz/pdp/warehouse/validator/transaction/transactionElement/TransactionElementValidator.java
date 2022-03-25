package uz.pdp.warehouse.validator.transaction.transactionElement;

import lombok.Setter;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Service
public class TransactionElementValidator extends AbstractValidator<TransactionElementCreateDto, TransactionElementUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id) || id < 0) {
            throw new ValidationException("INVALID_ID");
        }
    }

    @Override
    public void validOnCreate(TransactionElementCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.productId)) {
            throw new ValidationException("INVALID_PRODUCT_ID");
        } else if (Objects.isNull(createDto.transactionId)) {
            throw new ValidationException("INVALID_TRANSACTION_ID");
        } else if (Objects.isNull(createDto.count) || createDto.count < 0) {
            throw new ValidationException("INVALID_COUNT");
        } else if (Objects.isNull(createDto.price) || createDto.price < 0) {
            throw new ValidationException("INVALID_PRICE");
        }
    }

    @Override
    public void validOnUpdate(TransactionElementUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto.productId)) {
            throw new ValidationException("INVALID_PRODUCT_ID");
        } else if (Objects.isNull(updateDto.transactionId)) {
            throw new ValidationException("INVALID_TRANSACTION_ID");
        } else if (Objects.isNull(updateDto.count) || updateDto.count < 0) {
            throw new ValidationException("INVALID_COUNT");
        } else if (Objects.isNull(updateDto.price) || updateDto.price < 0) {
            throw new ValidationException("INVALID_PRICE");
        } else if (Objects.isNull(updateDto.totalPrice) || updateDto.totalPrice < 0) {
            throw new ValidationException("INVALID_TOTAL_PRICE");
        }
    }
}
