package uz.pdp.warehouse.dto.district;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

/**
 * @author Axmadjonov Eliboy, Thu 2:11 PM,3/17/2022
 */
@Getter
@Setter
public class DistrictCreateDto implements BaseGenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private Long agentId;
}
