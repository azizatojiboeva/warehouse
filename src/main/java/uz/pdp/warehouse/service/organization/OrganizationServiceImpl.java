package uz.pdp.warehouse.service.organization;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.mapper.organization.OrganizationMapper;
import uz.pdp.warehouse.repository.organization.OrganizationRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.organization.OrganizationValidator;

import java.util.List;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    protected OrganizationServiceImpl(OrganizationMapper mapper,
                                      OrganizationValidator validator,
                                      OrganizationRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(OrganizationCreateDto createDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(OrganizationUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<OrganizationDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<OrganizationDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<OrganizationDto>>> getAll() {
        return null;
    }
}
