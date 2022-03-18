package uz.pdp.warehouse.repository.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.warehouse.entity.product.ProductPlan;
import uz.pdp.warehouse.repository.base.AbstractRepository;
import uz.pdp.warehouse.repository.base.BaseGenericRepository;

import java.util.List;

public interface ProductPlanRepository extends AbstractRepository<ProductPlan, Long> {
    @Modifying
    @Transactional
    @Query(value = "update public.product_plan set is_deleted = true where id = :id", nativeQuery = true)
    void softDelete(@Param("id") Long id);

    @Query(value = "select * from public.product_plan where not is_deleted and id = :id ", nativeQuery = true)
    ProductPlan getByIdAndNotDeleted(@Param("id") Long id);

    @Query(value = "select * from public.product_plan where not is_deleted", nativeQuery = true)
    List<ProductPlan> getAllAndNotDeleted();

    @Query(value = "select * from public.product_plan where not is_deleted and id = :agentId", nativeQuery = true)
    List<ProductPlan> getAllAndByAgentId(@Param("agentId") Long agentId);
}
