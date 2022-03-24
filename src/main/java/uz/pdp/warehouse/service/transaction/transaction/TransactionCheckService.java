package uz.pdp.warehouse.service.transaction.transaction;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.exception.NotFoundException;

@Service
public class TransactionCheckService {

    public void checkTransactionExistence(Long id) {


        throw new NotFoundException("TRANSACTION_NOT_FOUND");
    }
}
