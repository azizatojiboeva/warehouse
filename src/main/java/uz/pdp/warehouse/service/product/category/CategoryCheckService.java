package uz.pdp.warehouse.service.product.category;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.product.Category;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.product.CategoryRepository;

import java.util.Objects;

@Service
public class CategoryCheckService {

    private final CategoryRepository repository;

    public CategoryCheckService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void checkCategoryExistence(Long id) {
        checkCategoryExistence(repository.getByIdAndNotDeleted(id));
    }

    public void checkCategoryExistence(Category category) {
        if (Objects.isNull(category)) {
            throw new NotFoundException("CATEGORY_NOT_FOUND");
        }
    }

}

