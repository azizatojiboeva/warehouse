package uz.pdp.warehouse.service.transaction.transactionElement;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.transaction.transactionElement.TransactionElementRepository;

import java.util.Objects;

@Service
public class TransactionElementCheckService {

    private final TransactionElementRepository repository;

    public TransactionElementCheckService(TransactionElementRepository repository) {
        this.repository = repository;
    }

    public void checkForExistence(Long transactionElementId) {
        checkForExistence(repository.findByIdAndDeletedFalse(transactionElementId));
    }

    public void checkForExistence(TransactionElement transactionElement) {
        if (Objects.isNull(transactionElement)) {
            throw new NotFoundException("TRANSACTION_ELEMENT_NOT_FOUND");
        }

    }

}
