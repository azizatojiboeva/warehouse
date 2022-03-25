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
        if (Objects.isNull(id)){
            throw new ValidationException("BAD_REQUEST");//"BAD_REQUEST_PLEASE_ENTER_DATA_IN_FULL"
        }
    }

    @Override
    public void validOnCreate(MarketCreateDto createDto) throws ValidationException {
            if (Objects.isNull(createDto.getName()) || Objects.isNull(createDto.getLongitude()) ||
                    Objects.isNull(createDto.getLatitude()) || Objects.isNull(createDto.getCredit()) ||
                    Objects.isNull(createDto.getDistrict_id())){
                throw new ValidationException("SOMETHING_WENT_WRONG");
            }
    }

    @Override
    public void validOnUpdate(MarketUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto.getName()) || Objects.isNull(updateDto.getLongitude()) ||
                Objects.isNull(updateDto.getLatitude()) || Objects.isNull(updateDto.getCredit())
               ){
            throw new ValidationException("SOMETHING_WENT_WRONG");
        }
    }
}
