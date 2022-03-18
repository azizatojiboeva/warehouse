package uz.pdp.warehouse.repository.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.product.Category;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;

public interface CategoryRepository extends AbstractRepository<Category, Long> {
    @Modifying
    @Transactional
    @Query(value = "update category set is_deleted = true where id = :id ", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);

    @Query(value = "select * from public.category where not is_deleted and id = :id ", nativeQuery = true)
    Category getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from public.category where not is_deleted", nativeQuery = true)
    List<Category> getAllAndNotDeleted();
}
