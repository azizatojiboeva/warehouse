package uz.pdp.warehouse.repository.market;

import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.repository.base.AbstractRepository;

/**
 * @author Axmadjonov Eliboy, Fri 12:19 AM,3/18/2022
 */
@Repository
public interface MarketRepository extends AbstractRepository<Market, Long> {

    Market findByIdAndDeletedFalse(Long id);

}
