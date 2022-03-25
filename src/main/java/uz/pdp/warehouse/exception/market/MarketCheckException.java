package uz.pdp.warehouse.exception.market;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketCheckException extends RuntimeException {
    public MarketCheckException(String message) {
        super(message);
    }


}
