package uz.pdp.warehouse.service.market;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.market.MarketCriteria;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.mapper.market.MarketMapper;
import uz.pdp.warehouse.repository.market.MarketRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.market.MarketValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Axmadjonov Eliboy, Fri 12:13 AM,3/18/2022
 */
@Service
public class MarketServiceImpl extends AbstractService<MarketRepository, MarketMapper, MarketValidator> implements MarketService {
    private final MarketCheckService marketCheckService;

    protected MarketServiceImpl(MarketMapper mapper, MarketValidator validator, MarketRepository repository, MarketCheckService marketCheckService) {
        super(mapper, validator, repository);
        this.marketCheckService = marketCheckService;
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
        boolean bool = repository.deleteSoft(id, String.valueOf(uuid));
        if (bool)
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Successfully deleted").status(HttpStatus.OK).build()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(MarketUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        marketCheckService.checkMarketExistence(updateDto.getId());
        Market market = mapper.fromUpdateDto(updateDto);
        Market save = repository.save(market);
        if (Objects.nonNull(save)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully updated").status(HttpStatus.OK).build()), HttpStatus.OK);
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("SOME_THING_WENT_WRONG_NOT_UPDATE").status(HttpStatus.BAD_REQUEST).build()));

    }

    @Override
    public ResponseEntity<DataDto<MarketDto>> get(Long id) {
        validator.validateKey(id);
        marketCheckService.checkMarketExistence(id);
        Optional<Market> byId = repository.getByIdAndNotDeleted(id);
        if (byId.isEmpty()) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("market not found").status(HttpStatus.NOT_FOUND).build()), HttpStatus.OK);
        Market market = byId.get();
        MarketDto marketDto = mapper.toDto(market);
        return new ResponseEntity<>(new DataDto<>(marketDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll(MarketCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Market> all = repository.findAll(pageable).getContent();
        List<MarketDto> marketDtos = mapper.toDto(all);
        return new ResponseEntity<>(new DataDto<>(marketDtos, (long) marketDtos.size()));
    }


    @Override
    public ResponseEntity<DataDto<List<MarketDto>>> getAll() {
        return null;
    }
}
