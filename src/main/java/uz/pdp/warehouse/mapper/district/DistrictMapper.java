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
    DistrictDto toDto(District entity) ;

    @Override
     List<DistrictDto> toDto(List<District> entities) ;
    @Override
    District fromCreateDto(DistrictCreateDto createDto) ;

    @Override
     District fromUpdateDto(DistrictUpdateDto updateDto) ;
}
