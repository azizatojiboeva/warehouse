package uz.pdp.warehouse.repository.transaction.transaction;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.transaction.Transaction;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;

public interface TransactionRepository extends AbstractRepository<Transaction, Long> {

    Transaction findByIdAndDeletedFalse(Long id);

    @Modifying
    @Transactional
    @Query(value = "update warehouse.public.transaction set is_deleted= true where id = :id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);

    List<Transaction> findAllByMarketIdAndDeletedFalse(Long id);
}
