package uz.pdp.warehouse.service.transaction.transaction;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.base.AbstractCriteria;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;
import uz.pdp.warehouse.entity.transaction.Transaction;
import uz.pdp.warehouse.mapper.transaction.TransactionMapper;
import uz.pdp.warehouse.repository.transaction.transaction.TransactionRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.market.MarketCheckService;
import uz.pdp.warehouse.validator.transaction.transaction.TransactionValidator;

import java.util.List;

@Service
public class TransactionServiceImpl
        extends AbstractService<TransactionRepository, TransactionMapper, TransactionValidator>
        implements TransactionService {

    private final MarketCheckService marketCheckService;
    private final TransactionCheckService transactionCheckService;

    protected TransactionServiceImpl(TransactionMapper mapper,
                                     TransactionValidator validator,
                                     TransactionRepository repository,
                                     MarketCheckService marketCheckService,
                                     TransactionCheckService transactionCheckService) {
        super(mapper, validator, repository);
        this.marketCheckService = marketCheckService;
        this.transactionCheckService = transactionCheckService;
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(TransactionCreateDto createDto) {
        validator.validOnCreate(createDto);
        marketCheckService.checkMarketExistence(createDto.marketId);
        Transaction transaction = mapper.fromCreateDto(createDto);
        Transaction newTransaction = repository.save(transaction);
        return new ResponseEntity<>(new DataDto<>(newTransaction.getId()));
    }


    @Override
    public ResponseEntity<DataDto<TransactionDto>> get(Long id) {
        validator.validateKey(id);
        Transaction transaction = repository.findByIdAndDeletedFalse(id);
        transactionCheckService.checkTransactionExistence(transaction);
        TransactionDto transactionDto = mapper.toDto(transaction);
        return new ResponseEntity<>(new DataDto<>(transactionDto));
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionDto>>> getAll(AbstractCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Transaction> transactions = repository.findAll(pageable).getContent();
        List<TransactionDto> transactionDtos = mapper.toDto(transactions);
        return new ResponseEntity<>(new DataDto<>(transactionDtos, (long) transactionDtos.size()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(TransactionUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        marketCheckService.checkMarketExistence(updateDto.marketId);
        repository.save(mapper.fromUpdateDto(updateDto));
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.deleteSoft(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionDto>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionDto>>> getAllByMarketId(Long id) {
        validator.validateKey(id);
        marketCheckService.checkMarketExistence(id);
        List<Transaction> transactions = repository.findAllByMarketIdAndDeletedFalse(id);
        List<TransactionDto> transactionDtos = mapper.toDto(transactions);
        return new ResponseEntity<>(new DataDto<>(transactionDtos, (long) transactionDtos.size()));
    }
}
