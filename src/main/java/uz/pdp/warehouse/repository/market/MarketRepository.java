package uz.pdp.warehouse.repository.market;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Axmadjonov Eliboy, Fri 12:19 AM,3/18/2022
 */
@Repository
public interface MarketRepository extends AbstractRepository<Market, Long> {



    @Query(value = " update public.market d set is_deleted = true , name = name||?2  where  d.id = ?1", nativeQuery = true)
    boolean deleteSoft(Long id, String toString);

    @Query(value = "select * from public.market where not is_deleted and id = :id", nativeQuery = true)
    Optional<Market> getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from public.market where not is_deleted", nativeQuery = true)
    List<Market> findAllAndNotIsDelete();

    Market findByIdAndDeletedFalse(Long marketId);
}
