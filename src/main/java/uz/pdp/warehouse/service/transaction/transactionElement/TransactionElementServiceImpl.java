package uz.pdp.warehouse.service.transaction.transactionElement;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.transaction.transactionElement.TransactionElementCriteria;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.mapper.transaction.transactionElement.TransactionElementMapper;
import uz.pdp.warehouse.repository.transaction.transactionElement.TransactionElementRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.product.product.ProductCheckService;
import uz.pdp.warehouse.service.transaction.transaction.TransactionCheckService;
import uz.pdp.warehouse.validator.transaction.transactionElement.TransactionElementValidator;

import java.util.List;

@Service
public class TransactionElementServiceImpl
        extends AbstractService<TransactionElementRepository, TransactionElementMapper, TransactionElementValidator>
        implements TransactionElementService {

    private final ProductCheckService productCheckService;
    private final TransactionCheckService transactionCheckService;
    private final TransactionElementCheckService transactionElementCheckService;


    protected TransactionElementServiceImpl(TransactionElementMapper mapper,
                                            TransactionElementValidator validator,
                                            TransactionElementRepository repository,
                                            ProductCheckService productCheckService,
                                            TransactionCheckService transactionCheckService1, TransactionElementCheckService transactionElementCheckService) {
        super(mapper, validator, repository);
        this.productCheckService = productCheckService;
        this.transactionCheckService = transactionCheckService1;
        this.transactionElementCheckService = transactionElementCheckService;
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(TransactionElementCreateDto createDto) {
        validator.validOnCreate(createDto);
        productCheckService.checkProductExistence(createDto.productId);
        transactionCheckService.checkTransactionExistence(createDto.productId);
        TransactionElement transactionElement = mapper.fromCreateDto(createDto);
        TransactionElement newTransactionElement = repository.save(transactionElement);
        return new ResponseEntity<>(new DataDto<>(newTransactionElement.getId()));
    }


    @Override
    public ResponseEntity<DataDto<TransactionElementDto>> get(Long id) {
        validator.validateKey(id);
        TransactionElement transactionElement = repository.findByIdAndDeletedFalse(id);
        transactionElementCheckService.checkForExistence(transactionElement);
        TransactionElementDto transactionElementDto = mapper.toDto(transactionElement);
        return new ResponseEntity<>(new DataDto<>(transactionElementDto));
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionElementDto>>> getAll(TransactionElementCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<TransactionElement> all = repository.findAll(pageable).getContent();
        List<TransactionElementDto> transactionElementDtos = mapper.toDto(all);
        return new ResponseEntity<>(new DataDto<>(transactionElementDtos, (long) transactionElementDtos.size()));
    }

    @Override
    public ResponseEntity<DataDto<List<TransactionElementDto>>> getAll() {
        return null;
    }

    public ResponseEntity<DataDto<List<TransactionElementDto>>> getAllByTransactionId(Long transactionId) {
        List<TransactionElement> transactionElements = repository.findByTransactionIdAndDeletedFalse(transactionId);
        List<TransactionElementDto> transactionElementDtos = mapper.toDto(transactionElements);
        return new ResponseEntity<>(new DataDto<>(transactionElementDtos, (long) transactionElementDtos.size()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(TransactionElementUpdateDto updateDto) {

        validator.validOnUpdate(updateDto);
        productCheckService.checkProductExistence(updateDto.productId);
        transactionCheckService.checkTransactionExistence(updateDto.productId);

        TransactionElement transactionElement = mapper.fromUpdateDto(updateDto);
        repository.save(transactionElement);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.deleteSoft(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }
}
