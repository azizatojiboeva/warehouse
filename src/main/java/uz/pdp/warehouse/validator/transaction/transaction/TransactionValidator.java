package uz.pdp.warehouse.validator.transaction.transaction;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

@Service
public class TransactionValidator extends AbstractValidator<TransactionCreateDto, TransactionUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TransactionCreateDto createDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TransactionUpdateDto updateDto) throws ValidationException {

    }
}
