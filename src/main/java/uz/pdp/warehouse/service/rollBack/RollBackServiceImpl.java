package uz.pdp.warehouse.service.rollBack;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.rollBack.RollBackCriteria;
import uz.pdp.warehouse.dto.rollBack.RollBackCreateDto;
import uz.pdp.warehouse.dto.rollBack.RollBackDto;
import uz.pdp.warehouse.dto.rollBack.RollBackUpdateDto;
import uz.pdp.warehouse.entity.rollback.Rollback;
import uz.pdp.warehouse.mapper.rollBack.RollBackMapper;
import uz.pdp.warehouse.repository.rollBack.RollBackRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.market.MarketCheckService;
import uz.pdp.warehouse.service.product.product.ProductCheckService;
import uz.pdp.warehouse.service.transaction.transaction.TransactionCheckService;
import uz.pdp.warehouse.validator.rollBack.RollBackValidator;

import java.util.List;

@Service
public class RollBackServiceImpl extends AbstractService<RollBackRepository, RollBackMapper, RollBackValidator>
        implements RollBackService {

    private final ProductCheckService productCheckService;
    private final TransactionCheckService transactionCheckService;
    private final MarketCheckService marketCheckService;
    private final RollBackCheckService rollBackCheckService;

    protected RollBackServiceImpl(RollBackMapper mapper,
                                  RollBackValidator validator,
                                  RollBackRepository repository,
                                  ProductCheckService productCheckService,
                                  TransactionCheckService transactionCheckService,
                                  MarketCheckService marketCheckService,
                                  RollBackCheckService rollBackCheckService) {
        super(mapper, validator, repository);
        this.productCheckService = productCheckService;
        this.transactionCheckService = transactionCheckService;
        this.marketCheckService = marketCheckService;
        this.rollBackCheckService = rollBackCheckService;
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(RollBackCreateDto createDto) {
        validator.validOnCreate(createDto);
        marketCheckService.checkMarketExistence(createDto.market_id);
        productCheckService.checkProductExistence(createDto.rollBackedProductId.id);
        transactionCheckService.checkTransactionExistence(createDto.transactionId.id);
        Rollback newRollBack = repository.save(mapper.fromCreateDto(createDto));
        return new ResponseEntity<>(new DataDto<>(newRollBack.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.deleteByIdAndNotDeleted(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(RollBackUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Rollback oldRollBack = repository.getByIdAndDeletedFalse(updateDto.id);
        rollBackCheckService.checkRollBackExistence(oldRollBack);
        productCheckService.checkProductExistence(updateDto.rollBackedProductId.id);
        marketCheckService.checkMarketExistence(updateDto.marketId);
        transactionCheckService.checkTransactionExistence(updateDto.oldTransaction.id);
        transactionCheckService.checkTransactionExistence(updateDto.newTransaction.id);
        Rollback rollback = mapper.fromUpdateDto(updateDto, oldRollBack);
        repository.save(rollback);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }


    @Override
    public ResponseEntity<DataDto<RollBackDto>> get(Long id) {
        validator.validateKey(id);
        Rollback rollback = repository.getByIdAndDeletedFalse(id);
        rollBackCheckService.checkRollBackExistence(rollback);
        RollBackDto rollBackDto = mapper.toDto(rollback);
        return new ResponseEntity<>(new DataDto<>(rollBackDto));
    }

    @Override
    public ResponseEntity<DataDto<List<RollBackDto>>> getAll(RollBackCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Rollback> rollbacks = repository.findAll(pageable).getContent();
        List<RollBackDto> rollBackDtos = mapper.toDto(rollbacks);
        return new ResponseEntity<>(new DataDto<>(rollBackDtos, (long) rollBackDtos.size()));
    }

    @Override
    public ResponseEntity<DataDto<List<RollBackDto>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<RollBackDto>>> getAllByMarketId(Long id) {
        validator.validateKey(id);
        marketCheckService.checkMarketExistence(id);
        List<Rollback> rollBacks = repository.getAllByMarketIdAndDeletedFalse(id);
        List<RollBackDto> rollBackDtos = mapper.toDto(rollBacks);
        return new ResponseEntity<>(new DataDto<>(rollBackDtos, (long) rollBackDtos.size()));
    }
}
