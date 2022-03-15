package uz.pdp.warehouse.service.product.category;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.mapper.product.CategoryMapper;
import uz.pdp.warehouse.repository.product.CategoryRepository;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.CategoryValidator;

import java.util.List;

@Service
public class CategoryServiceImpl extends AbstractService<CategoryRepository, CategoryMapper, CategoryValidator>
        implements CategoryService {


    private CategoryServiceImpl(CategoryMapper mapper,
                                  CategoryValidator validator,
                                  CategoryRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(CategoryCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Boolean update(CategoryUpdateDto updateDto) {
        return null;
    }

    @Override
    public CategoryDto get(Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAll(Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }
}
