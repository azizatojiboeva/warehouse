package uz.pdp.warehouse.service.transaction.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.base.AbstractCriteria;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;
import uz.pdp.warehouse.entity.transaction.Transaction;
import uz.pdp.warehouse.exception.market.MarketCheckException;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.mapper.transaction.TransactionMapper;
import uz.pdp.warehouse.repository.transaction.transaction.TransactionRepository;
import uz.pdp.warehouse.response.AppErrorDto;
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

    protected TransactionServiceImpl(TransactionMapper mapper,
                                     TransactionValidator validator,
                                     TransactionRepository repository, MarketCheckService marketCheckService) {
        super(mapper, validator, repository);
        this.marketCheckService = marketCheckService;
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(TransactionCreateDto createDto) {
        try {
            validator.validOnCreate(createDto);
            marketCheckService.checkMarketExistence(createDto.marketId);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build()));
        } catch (MarketCheckException me) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(me.getMessage())
                    .status(HttpStatus.NOT_FOUND)
                    .build()));
        }
        Transaction transaction = mapper.fromCreateDto(createDto);
        Transaction newTransaction = repository.save(transaction);
        return new ResponseEntity<>(new DataDto<>(newTransaction.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(TransactionUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<TransactionDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionDto>>> getAll(AbstractCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionDto>>> getAll() {
        return null;
    }
}
