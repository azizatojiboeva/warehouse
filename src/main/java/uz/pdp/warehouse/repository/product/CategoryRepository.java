package uz.pdp.warehouse.repository.product;

import org.springframework.data.jpa.repository.Query;
import uz.pdp.warehouse.entity.product.Category;
import uz.pdp.warehouse.repository.base.AbstractRepository;

public interface CategoryRepository extends AbstractRepository<Category, Long> {

}
