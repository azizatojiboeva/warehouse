package uz.pdp.warehouse.dto.market;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @author Axmadjonov Eliboy, Fri 12:05 AM,3/18/2022
 */
@Getter
@Setter
public class MarketDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private Double credit;

    @Builder(builderMethodName = "childBuilder")
    public MarketDto(Long id) {
        super(id);
    }
}
