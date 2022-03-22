package uz.pdp.warehouse.repository.transaction.transactionElement;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;

public interface TransactionElementRepository extends AbstractRepository<TransactionElement, Long> {
    TransactionElement findByIdAndDeletedFalse(Long id);

    @Modifying
    @Transactional
    @Query(value = "update public.transaction_element set is_deleted = true where id = :id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);

    List<TransactionElement> findByTransactionIdAndDeletedFalse(Long transactionId);
}
