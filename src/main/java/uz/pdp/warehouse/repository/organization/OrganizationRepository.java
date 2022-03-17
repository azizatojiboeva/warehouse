package uz.pdp.warehouse.repository.organization;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationRepository extends AbstractRepository<Organization, Long> {

    @Modifying
    @Transactional
    @Query(value = "update public.organization set website=website||:uuid,name=name||:uuid,email=email||:uuid,is_deleted = true where id = :id", nativeQuery = true)
    void softDelete(@Param("id") Long id, UUID uuid);

    @Query(value = "select * from organization where not is_deleted and id = :id", nativeQuery = true)
    Organization getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from organization where not is_deleted", nativeQuery = true)
    List<Organization> getAllAndNotDeleted();


}
