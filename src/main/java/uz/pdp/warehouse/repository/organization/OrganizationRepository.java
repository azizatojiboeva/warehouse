package uz.pdp.warehouse.repository.organization;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.repository.base.AbstractRepository;
import uz.pdp.warehouse.service.organization.OrganizationCheckService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends AbstractRepository<Organization, Long> {

    @Modifying
    @Transactional
    @Query(value = "update public.organization set website=website||:uuid,name=name||:uuid,email=email||:uuid,is_deleted = true where id = :id", nativeQuery = true)
    void softDelete(@Param("id") Long id, @Param("uuid") UUID uuid);

    @Query(value = "select * from organization where not is_deleted and id = :id", nativeQuery = true)
    Optional<Organization> getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from organization where not is_deleted", nativeQuery = true)
    Optional<List<Organization>> getAllAndNotDeleted();


    Organization findByIdAndDeletedFalse(Long id);
}
