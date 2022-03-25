package uz.pdp.warehouse.service.organization;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.organization.OrganizationRepository;

import java.util.Objects;

@Service
public class OrganizationCheckService {

    private final OrganizationRepository repository;


    public OrganizationCheckService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public void checkForOrganizationExistence(Long id) {
        checkForOrganizationExistence(repository.findByIdAndDeletedFalse(id));
    }

    public void checkForOrganizationExistence(Organization organization) {
        if (Objects.isNull(organization)) {
            throw new NotFoundException("ORGANIZATION_NOT_FOUND");
        }
    }

}
