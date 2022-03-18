package uz.pdp.warehouse.dto.district;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @author Axmadjonov Eliboy, Thu 2:09 PM,3/17/2022
 */

@Getter
@Setter
public class DistrictDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private Long agentId;

    @Builder(builderMethodName = "childBuilder")
    public DistrictDto(Long id) {
        super(id);
    }
}
