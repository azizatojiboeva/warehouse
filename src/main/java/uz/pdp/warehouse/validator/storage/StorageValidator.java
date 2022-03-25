package uz.pdp.warehouse.validator.storage;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;

@Component
public class StorageValidator extends AbstractValidator<StorageCreateDto, StorageUpdateDto, Long> {

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(StorageCreateDto createDto) throws ValidationException {

        if (Objects.isNull(createDto.getName()) || Objects.isNull(createDto.getLatitude())
                || Objects.isNull(createDto.getLongitude()) || Objects.isNull(createDto.getOrganization_id())){
            throw new ValidationException("SOMETHING_WANT_WRONG_PLEASE_ENTER_DATA_IN_FULL");
        }

    }

    @Override
    public void validOnUpdate(StorageUpdateDto updateDto) throws ValidationException {

        if ( Objects.isNull(updateDto.getName()) || Objects.isNull(updateDto.getLatitude())
                || Objects.isNull(updateDto.getLongitude()) || Objects.isNull(updateDto.getOrganization_id())
                || Objects.isNull(updateDto.getId()) ){
            throw new ValidationException("SOMETHING_WANT_WRONG_PLEASE_ENTER_DATA_IN_FULL");
        }

    }
}
