package uz.pdp.warehouse.service.transaction.transaction;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.transaction.Transaction;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.transaction.transaction.TransactionRepository;

import java.util.Objects;

@Service
public class TransactionCheckService {

    private final TransactionRepository repository;

    public TransactionCheckService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void checkTransactionExistence(Long id) {
        checkTransactionExistence(repository.findByIdAndDeletedFalse(id));
    }

    public void checkTransactionExistence(Transaction transaction) {
        if (Objects.isNull(transaction)) {
            throw new NotFoundException("TRANSACTION_NOT_FOUND");
        }
    }
}
