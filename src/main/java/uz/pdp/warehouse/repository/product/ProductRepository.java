package uz.pdp.warehouse.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.warehouse.entity.organization.Organization;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends AbstractRepository<Product,Long> {

    @Query(value = "update public.product set name=name ||:uuid,is_deleted = true where id = :id", nativeQuery=true)
    boolean softDelete(@Param("id") Long id, @Param("uuid") UUID uuid);

    @Query(value = "select * from product where not is_deleted and id = :id", nativeQuery = true)
    Optional<Product> getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from product where not is_deleted", nativeQuery = true)
    List<Product> getAllAndNotDeleted();

}
