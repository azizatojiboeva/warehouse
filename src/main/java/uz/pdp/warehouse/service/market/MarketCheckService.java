package uz.pdp.warehouse.service.market;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.market.Market;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.market.MarketRepository;

import java.util.Optional;

@Service
public class MarketCheckService {

    private final MarketRepository repository;

    public MarketCheckService(MarketRepository repository) {
        this.repository = repository;
    }

    public void checkMarketExistence(Long marketId) {
        Optional<Market> byId = repository.findById(marketId);
        if (byId.isEmpty()) {
            throw new NotFoundException("MARKET_NOT_FOUND");
        }
    }
}
