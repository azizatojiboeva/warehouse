package uz.pdp.warehouse.service.market;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.mapper.market.MarketMapper;
import uz.pdp.warehouse.repository.market.MarketRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.market.MarketValidator;

import java.util.List;

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
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(MarketUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<MarketDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll() {
        return null;
    }
}
