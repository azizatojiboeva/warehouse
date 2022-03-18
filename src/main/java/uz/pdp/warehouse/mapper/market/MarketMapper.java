package uz.pdp.warehouse.mapper.market;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Fri 12:21 AM,3/18/2022
 */
@Component
@Mapper(componentModel = "spring")
public interface MarketMapper extends AbstractMapper<Market, MarketDto, MarketCreateDto, MarketUpdateDto> {
    @Override
    MarketDto toDto(Market entity);

    @Override
    List<MarketDto> toDto(List<Market> entities);

    @Override
    Market fromCreateDto(MarketCreateDto createDto);

    @Override
    Market fromUpdateDto(MarketUpdateDto updateDto);
}
