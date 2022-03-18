package uz.pdp.warehouse.validator.organization;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrganizationCreateDto createDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto updateDto) throws ValidationException {

    }

    public void validOnExistenceList(Optional<List<Organization>> optionalOrganizations) {
        if (optionalOrganizations.isEmpty()) {
            throw new ValidationException("NOT_FOUND_ORGANIZATION");
        }
    }
}
