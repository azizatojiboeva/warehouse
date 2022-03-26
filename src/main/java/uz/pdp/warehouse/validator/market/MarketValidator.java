package uz.pdp.warehouse.validator.market;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.Objects;


@Component
public class MarketValidator extends AbstractValidator<MarketCreateDto, MarketUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id) || id < 0) {
            throw new ValidationException("INVALID_ID");
        }
    }

    @Override
    public void validOnCreate(MarketCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.getName())) {
            throw new ValidationException("INVALID_NAME");
        } else if (Objects.isNull(createDto.getLongitude()) || createDto.getLongitude() < 0) {
            throw new ValidationException("INVALID_LONGITUDE");
        } else if (Objects.isNull(createDto.getLatitude()) || createDto.getLatitude() < 0) {
            throw new ValidationException("INVALID_LATITUDE");
        } else if (Objects.isNull(createDto.getCredit()) || createDto.getCredit() < 0) {
            throw new ValidationException("INVALID_NAME");
        } else if (Objects.isNull(createDto.getDistrict_id()) || createDto.getDistrict_id() < 0) {
            throw new ValidationException("INVALID_DISTRICT_ID");
        }
    }

    @Override
    public void validOnUpdate(MarketUpdateDto updateDto) throws ValidationException {
        validateKey(updateDto.id);
    }
}
