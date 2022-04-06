package uz.pdp.warehouse.service.organization;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.organization.OrganizationCriteria;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.mapper.organization.OrganizationMapper;
import uz.pdp.warehouse.repository.organization.OrganizationRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.organization.OrganizationValidator;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    protected OrganizationServiceImpl(OrganizationMapper mapper,
                                      OrganizationValidator validator,
                                      OrganizationRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(OrganizationCreateDto createDto)  {
        validator.validOnCreate(createDto);
        Organization organization = mapper.fromCreateDto(createDto);
        Organization newOrganization = repository.save(organization);
        return new ResponseEntity<>(new DataDto<>(newOrganization.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        UUID uuid = UUID.randomUUID();
        repository.softDelete(id, uuid);
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(OrganizationUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Organization organization = mapper.fromUpdateDto(updateDto);
        repository.save(organization);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }


    @Override
    public ResponseEntity<DataDto<OrganizationDto>> get(Long id) {
        validator.validateKey(id);
        Optional<Organization> organization = repository.getByIdAndNotDeleted(id);
        OrganizationDto organizationDto = mapper.toDto(organization.get());
        return new ResponseEntity<>(new DataDto<>(organizationDto));
    }

    @Override
    public ResponseEntity<DataDto<List<OrganizationDto>>> getAll(OrganizationCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Organization> content = repository.findAll(pageable).getContent();
        List<OrganizationDto> organizationDtos = mapper.toDto(content);
        return new ResponseEntity<>(new DataDto<>(organizationDtos, (long) content.size()));
    }

    @Override
    public ResponseEntity<DataDto<List<OrganizationDto>>> getAll() {
        Optional<List<Organization>> optionalOrganizations = repository.getAllAndNotDeleted();
        List<OrganizationDto> organizationDtos = mapper.toDto(optionalOrganizations.get());
        return new ResponseEntity<>(new DataDto<>(organizationDtos, (long) organizationDtos.size()));
    }
}
