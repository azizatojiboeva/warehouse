package uz.pdp.warehouse.dto.district;

import lombok.Builder;
import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @author Axmadjonov Eliboy, Thu 2:12 PM,3/17/2022
 */
public class DistrictUpdateDto extends GenericDto {


    @Builder(builderMethodName = "childBuilder")
    public DistrictUpdateDto(Long id) {
        super(id);
    }
}
