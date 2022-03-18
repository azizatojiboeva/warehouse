package uz.pdp.warehouse.validator.market;

import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

/**
 * @author Axmadjonov Eliboy, Fri 12:16 AM,3/18/2022
 */
@Component
public class MarketValidator extends AbstractValidator<MarketCreateDto, MarketUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(MarketCreateDto createDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(MarketUpdateDto updateDto) throws ValidationException {

    }
}
