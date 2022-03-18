package uz.pdp.warehouse.dto.district;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @author Axmadjonov Eliboy, Thu 2:12 PM,3/17/2022
 */

@Getter
@Setter
public class DistrictUpdateDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    @Builder(builderMethodName = "childBuilder")
    public DistrictUpdateDto(Long id) {
        super(id);
    }
}
