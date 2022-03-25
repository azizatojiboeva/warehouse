package uz.pdp.warehouse.service.market;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.market.MarketCriteria;
import uz.pdp.warehouse.dto.district.DistrictDto;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.entity.district.District;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.mapper.market.MarketMapper;
import uz.pdp.warehouse.repository.market.MarketRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.market.MarketValidator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author Axmadjonov Eliboy, Fri 12:13 AM,3/18/2022
 */
@Service
public class MarketServiceImpl extends AbstractService<MarketRepository, MarketMapper, MarketValidator> implements MarketService {
    protected MarketServiceImpl(MarketMapper mapper, MarketValidator validator, MarketRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(MarketCreateDto createDto) {
        validator.validOnCreate(createDto);
        Market market = mapper.fromCreateDto(createDto);
        Market save = repository.save(market);
        return new ResponseEntity<>(new DataDto<>(save.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        UUID uuid = UUID.randomUUID();
        repository.deleteSoft(id, uuid.toString());
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(MarketUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Market market = mapper.fromUpdateDto(updateDto);
        repository.save(market);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }

    @Override
    public ResponseEntity<DataDto<MarketDto>> get(Long id) {
        validator.validateKey(id);
        Market market = repository.getByIdAndNotDelete(id);
        MarketDto marketDto = mapper.toDto(market);
        return new ResponseEntity<>(new DataDto<>(marketDto));
    }

    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll(MarketCriteria criteria) {
        return null;
    }


    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll() {
        List<Market> marketList = repository.findAllAndNotIsDelete();
        List<MarketDto> marketDtoList = mapper.toDto(marketList);
        return new ResponseEntity<>(new DataDto<>(marketDtoList));
    }
}
