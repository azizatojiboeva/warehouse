package uz.pdp.warehouse.validator.district;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;


@Component
public class DistrictValidator extends AbstractValidator<DistrictCreateDto, DistrictUpdateDto, Long> {
    @Override
    public void validateKey(Long id) {
        if (Objects.isNull(id)) {
            throw new ValidationException("BAD_REQUEST");
        }
    }

    @Override
    public void validOnCreate(DistrictCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.getName()) || Objects.isNull(createDto.getLongitude()) ||
                Objects.isNull(createDto.getLatitude()) || Objects.isNull(createDto.getAgentId())) {
            throw new ValidationException("SOMETHING_WENT_WRONG");
        }
    }

    @Override
    public void validOnUpdate(DistrictUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto.getName()) || Objects.isNull(updateDto.getLongitude()) ||
                Objects.isNull(updateDto.getLatitude())) {
            throw new ValidationException("SOMETHING_WENT_WRONG");
        }
    }
}
