package uz.pdp.warehouse.service.product.category;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.entity.product.Category;
import uz.pdp.warehouse.mapper.product.CategoryMapper;
import uz.pdp.warehouse.repository.product.CategoryRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
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
    public ResponseEntity<DataDto<Long>> create(CategoryCreateDto createDto) {
        validator.validOnCreate(createDto);
        Category category = mapper.fromCreateDto(createDto);
        Category newCategory = repository.save(category);
        return new ResponseEntity<>(new DataDto<>(newCategory.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(CategoryUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Category category = mapper.fromUpdateDto(updateDto);

//        repository.update(category);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }


    @Override
    public ResponseEntity<DataDto<CategoryDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<CategoryDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<CategoryDto>>> getAll() {
        return null;
    }
}
