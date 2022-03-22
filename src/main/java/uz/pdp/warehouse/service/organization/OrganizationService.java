package uz.pdp.warehouse.service.organization;

import uz.pdp.warehouse.criteria.organization.OrganizationCriteria;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

public interface OrganizationService extends GenericCrudService<OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        OrganizationCriteria,
        Long> {

    @Override
    ResponseEntity<DataDto<Long>> create(OrganizationCreateDto createDto);

    @Override
    ResponseEntity<DataDto<Void>> delete(Long id);

    @Override
    ResponseEntity<DataDto<Boolean>> update(OrganizationUpdateDto updateDto);


    @Override
    ResponseEntity<DataDto<List<OrganizationDto>>> getAll();
}
