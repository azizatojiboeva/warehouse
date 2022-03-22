package uz.pdp.warehouse.service.transaction.transactionElement;

import uz.pdp.warehouse.criteria.transaction.transactionElement.TransactionElementCriteria;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

public interface TransactionElementService extends GenericCrudService<
        TransactionElementDto,
        TransactionElementCreateDto,
        TransactionElementUpdateDto,
        TransactionElementCriteria,
        Long
        > {
    ResponseEntity<DataDto<List<TransactionElementDto>>> getAllByTransactionId(Long transactionId);
}
