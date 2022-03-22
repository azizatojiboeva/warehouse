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

    }

    @Override
    public void validOnCreate(TransactionElementCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.productId)) {
            throw new ValidationException("ID_IS_INVALID");
        }//TODO CHECKING
    }

    @Override
    public void validOnUpdate(TransactionElementUpdateDto updateDto) throws ValidationException {

    }
}
