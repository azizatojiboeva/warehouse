package uz.pdp.warehouse.mapper.district;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.entity.district.District;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 2:17 PM,3/17/2022
 */
@Component
@Mapper(componentModel = "spring")
public interface DistrictMapper extends AbstractMapper<District, DistrictDto, DistrictCreateDto, DistrictUpdateDto> {
    @Override
    default DistrictDto toDto(District entity) {
        return null;
    }

    @Override
    default List<DistrictDto> toDto(List<District> entities) {
        return null;
    }

    @Override
    default District fromCreateDto(DistrictCreateDto createDto) {
        return null;
    }

    @Override
    default District fromUpdateDto(DistrictUpdateDto updateDto) {
        return null;
    }
}
