package uz.pdp.warehouse.dto.market;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

import javax.validation.constraints.NotNull;

/**
 * @author Axmadjonov Eliboy, Fri 12:05 AM,3/18/2022
 */

@Getter
@Setter
public class MarketCreateDto implements BaseGenericDto {
@NotNull
    private String name;

    private Double latitude;

    private Double longitude;

    private Double credit;

    private Long district_id;

}
