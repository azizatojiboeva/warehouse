package uz.pdp.warehouse.validator.organization;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.validator.base.AbstractValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto, OrganizationUpdateDto, Long> {

    private final String regexEmail = "\\\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b";
    private final String regexWebsite = "^(.+)@(.+)$";

    @Override
    public void validateKey(Long id) throws ValidationException {
        if (Objects.isNull(id) || id < 0) {
            throw new ValidationException("INVALID_ID");
        }
    }

    @Override
    public void validOnCreate(OrganizationCreateDto createDto) throws ValidationException {
        if (Objects.isNull(createDto.website) || Pattern.matches(regexWebsite, createDto.website)) {
            throw new ValidationException("INVALID_WEBSITE");
        } else if (Objects.isNull(createDto.email) || Pattern.matches(regexEmail, createDto.website)) {
            throw new ValidationException("INVALID_EMAIL");
        } else if (Objects.isNull(createDto.name)) {
            throw new ValidationException("INVALID_NAME");
        } else if (createDto.latitude < 0) {
            throw new ValidationException("INVALID_LATITUDE");
        } else if (createDto.longitude < 0) {
            throw new ValidationException("INVALID_LONGITUDE");
        }
    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto updateDto) throws ValidationException {
        if (Objects.isNull(updateDto.id) || updateDto.id < 0) {
            throw new ValidationException("INVALID_ID");
        } else if (Objects.isNull(updateDto.website) || Pattern.matches(regexWebsite, updateDto.website)) {
            throw new ValidationException("INVALID_WEBSITE");
        } else if (Objects.isNull(updateDto.email) || Pattern.matches(regexEmail, updateDto.website)) {
            throw new ValidationException("INVALID_EMAIL");
        } else if (Objects.isNull(updateDto.name)) {
            throw new ValidationException("INVALID_NAME");
        } else if (updateDto.latitude < 0) {
            throw new ValidationException("INVALID_LATITUDE");
        } else if (updateDto.longitude < 0) {
            throw new ValidationException("INVALID_LONGITUDE");
        }
    }

}
