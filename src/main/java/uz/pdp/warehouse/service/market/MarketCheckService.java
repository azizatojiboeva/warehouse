package uz.pdp.warehouse.service.market;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.exception.market.MarketCheckException;

@Service
public class MarketCheckService {


    public void checkMarketExistence(Long marketId) {

//        throw new MarketCheckException("MARKET_NOT_FOUND");
    }
}
