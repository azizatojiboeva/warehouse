package uz.pdp.warehouse.service.transaction.transactionElement;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.transaction.transactionElement.TransactionElementCriteria;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.exception.product.ProductCheckException;
import uz.pdp.warehouse.exception.transaction.TransactionCheckException;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.mapper.transaction.transactionElement.TransactionElementMapper;
import uz.pdp.warehouse.repository.transaction.transactionElement.TransactionElementRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.product.product.ProductCheckService;
import uz.pdp.warehouse.service.transaction.transaction.TransactionCheckService;
import uz.pdp.warehouse.validator.transaction.transactionElement.TransactionElementValidator;


import java.util.List;
import java.util.Objects;

@Service
public class TransactionElementServiceImpl
        extends AbstractService<TransactionElementRepository, TransactionElementMapper, TransactionElementValidator>
        implements TransactionElementService {

    private final ProductCheckService productCheckService;
    private final TransactionCheckService transactionCheckService;


    protected TransactionElementServiceImpl(TransactionElementMapper mapper,
                                            TransactionElementValidator validator,
                                            TransactionElementRepository repository,
                                            ProductCheckService productCheckService,
                                            TransactionCheckService transactionCheckService1) {
        super(mapper, validator, repository);
        this.productCheckService = productCheckService;
        this.transactionCheckService = transactionCheckService1;
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(TransactionElementCreateDto createDto) {
//        AppErrorDto errorDto = checkFields(createDto.productId, createDto.transactionId);
//        if (Objects.nonNull(errorDto)) {
//            return new ResponseEntity<>(new DataDto<>(errorDto));
//        }
//
//        try {
        validator.validOnCreate(createDto);
        productCheckService.checkProductExistence(createDto.productId);
        transactionCheckService.checkTransactionExistence(createDto.productId);
//        } catch (ValidationException e) {
//            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
//                    .message(e.getMessage())
//                    .status(HttpStatus.BAD_REQUEST)
//                    .build()));
//        }
        TransactionElement transactionElement = mapper.fromCreateDto(createDto);
        TransactionElement newTransactionElement = repository.save(transactionElement);
        return new ResponseEntity<>(new DataDto<>(newTransactionElement.getId()));
    }


    @Override
    public ResponseEntity<DataDto<TransactionElementDto>> get(Long id) {
        validator.validateKey(id);
        TransactionElement transactionElement = repository.findByIdAndDeletedFalse(id);
        if (Objects.isNull(transactionElement)) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message("TRANSACTION_ELEMENT_NOT_FOUND")
                    .status(HttpStatus.NOT_FOUND)
                    .build()));
        }
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
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        try {
            validator.validateKey(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build()));
        }
        repository.deleteSoft(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(TransactionElementUpdateDto updateDto) {

        AppErrorDto errorDto = checkFields(updateDto.productId, updateDto.transactionId);
        if (Objects.nonNull(errorDto)) {
            return new ResponseEntity<>(new DataDto<>(errorDto));
        }

        try {
            validator.validOnUpdate(updateDto);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build()));
        }

        TransactionElement transactionElement = mapper.fromUpdateDto(updateDto);
        repository.save(transactionElement);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }

//    private AppErrorDto checkFields(Long productId, Long transactionId) {
//        try {
//
//        } catch (ProductCheckException pe) {
//            return AppErrorDto.builder()
//                    .message("PRODUCT_NOT_FOUND")
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        } catch (TransactionCheckException te) {
//            return AppErrorDto.builder()
//                    .message("TRANSACTION_NOT_FOUND")
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        }
//        return null;
//    }

}

