package uz.pdp.warehouse.mapper.organization;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends AbstractMapper<Organization, OrganizationDto, OrganizationCreateDto, OrganizationUpdateDto> {
    @Override
    OrganizationDto toDto(Organization entity);

    @Override
    List<OrganizationDto> toDto(List<Organization> entities);

    @Override
    Organization fromCreateDto(OrganizationCreateDto createDto);

    @Override
    Organization fromUpdateDto(OrganizationUpdateDto updateDto);
}
