package uz.pdp.warehouse.validator.organization;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

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
}
