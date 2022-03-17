package uz.pdp.warehouse.service.district;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.entity.district.District;
import uz.pdp.warehouse.mapper.district.DistrictMapper;
import uz.pdp.warehouse.repository.district.DistrictRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.district.DistrictValidator;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 2:07 PM,3/17/2022
 */
@Service
public class DistrictServiceImpl extends AbstractService<DistrictRepository, DistrictMapper, DistrictValidator> implements DistrictService {


    protected DistrictServiceImpl(DistrictMapper mapper, DistrictValidator validator, DistrictRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(DistrictCreateDto createDto) {
        validator.validOnCreate(createDto);
        District district = mapper.fromCreateDto(createDto);
        District save = repository.save(district);
        return new ResponseEntity<>(new DataDto<>(save.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(DistrictUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<DistrictDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<DistrictDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<DistrictDto>>> getAll() {
        return null;
    }
}
