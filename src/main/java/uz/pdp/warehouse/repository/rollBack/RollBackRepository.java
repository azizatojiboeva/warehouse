package uz.pdp.warehouse.repository.rollBack;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.rollback.Rollback;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;

public interface RollBackRepository extends AbstractRepository<Rollback, Long> {

    List<Rollback> getAllByMarketIdAndDeletedFalse(Long id);

    Rollback getByIdAndDeletedFalse(Long id);

    @Modifying
    @Transactional
    @Query(value = "update public.rollback set is_deleted = true where id = :id", nativeQuery = true)
    void deleteByIdAndNotDeleted(@Param("id") Long id);


}
