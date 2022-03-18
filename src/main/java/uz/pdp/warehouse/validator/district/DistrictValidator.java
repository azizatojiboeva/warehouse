package uz.pdp.warehouse.validator.district;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

/**
 * @author Axmadjonov Eliboy, Thu 2:20 PM,3/17/2022
 */
@Component
public class DistrictValidator extends AbstractValidator<DistrictCreateDto, DistrictUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(DistrictCreateDto createDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(DistrictUpdateDto updateDto) throws ValidationException {

    }
}
