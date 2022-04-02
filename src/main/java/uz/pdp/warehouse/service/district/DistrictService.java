package uz.pdp.warehouse.service.district;

import uz.pdp.warehouse.criteria.district.DistrictCriteria;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 2:06 PM,3/17/2022
 */
public interface DistrictService extends
        GenericCrudService<DistrictDto, DistrictCreateDto, DistrictUpdateDto, DistrictCriteria, Long> {
    @Override
    ResponseEntity<DataDto<Long>> create(DistrictCreateDto createDto);

    @Override
    ResponseEntity<DataDto<Void>> delete(Long id);

    @Override
    ResponseEntity<DataDto<Boolean>> update(DistrictUpdateDto updateDto);

    @Override
    ResponseEntity<DataDto<DistrictDto>> get(Long id);

    @Override
    ResponseEntity<DataDto<List<DistrictDto>>> getAll();
}
