package uz.pdp.warehouse.service.market;

import uz.pdp.warehouse.criteria.market.MarketCriteria;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Fri 12:13 AM,3/18/2022
 */
public interface MarketService extends GenericCrudService<MarketDto, MarketCreateDto, MarketUpdateDto, MarketCriteria,Long> {
    @Override
    ResponseEntity<DataDto<Long>> create(MarketCreateDto createDto);

    @Override
    ResponseEntity<DataDto<Void>> delete(Long id);

    @Override
    ResponseEntity<DataDto<Boolean>> update(MarketUpdateDto updateDto);

    @Override
    ResponseEntity<DataDto<MarketDto>> get(Long id);

    @Override
    ResponseEntity<DataDto<List<MarketDto>>> getAll();
}
