package uz.pdp.warehouse.service.market;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.exception.market.MarketCheckException;
import uz.pdp.warehouse.repository.market.MarketRepository;

import java.util.Objects;

@Service
public class MarketCheckService {

    private final MarketRepository repository;

    public MarketCheckService(MarketRepository repository) {
        this.repository = repository;
    }

    public void checkMarketExistence(Long marketId) {
        Optional<Market> byId = repository.findById(marketId);
        if (!byId.isPresent()){
            throw new MarketCheckException("INVALID_ID");
        }
    }
}
