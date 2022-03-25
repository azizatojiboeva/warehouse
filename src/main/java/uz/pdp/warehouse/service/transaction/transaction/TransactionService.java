package uz.pdp.warehouse.service.transaction.transaction;


import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.base.AbstractCriteria;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

public interface TransactionService extends
        GenericCrudService<TransactionDto, TransactionCreateDto, TransactionUpdateDto, AbstractCriteria, Long> {
    @Override
    ResponseEntity<DataDto<Long>> create(TransactionCreateDto createDto);

    @Override
    ResponseEntity<DataDto<Void>> delete(Long id);

    @Override
    ResponseEntity<DataDto<Boolean>> update(TransactionUpdateDto updateDto);

    @Override
    ResponseEntity<DataDto<TransactionDto>> get(Long id);

    @Override
    ResponseEntity<DataDto<List<TransactionDto>>> getAll(AbstractCriteria criteria);

    @Override
    ResponseEntity<DataDto<List<TransactionDto>>> getAll();

    ResponseEntity<DataDto<List<TransactionDto>>> getAllByMarketId(Long id);
}
