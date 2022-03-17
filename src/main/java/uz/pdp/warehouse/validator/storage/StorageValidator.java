package uz.pdp.warehouse.validator.storage;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

@Component
public class StorageValidator extends AbstractValidator<StorageCreateDto, StorageUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(StorageCreateDto createDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(StorageUpdateDto updateDto) throws ValidationException {

    }
}
