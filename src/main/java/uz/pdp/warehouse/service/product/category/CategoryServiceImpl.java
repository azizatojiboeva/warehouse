package uz.pdp.warehouse.service.product.category;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.product.category.CategoryCriteria;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.dto.product.category.SubCategoryCreateDto;
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
    public ResponseEntity<DataDto<Long>> subCategoryCreate(SubCategoryCreateDto subCategoryCreateDto) {
        Category category = mapper.fromSubCategoryCreateDto(subCategoryCreateDto);
        Category newCategory = repository.save(category);
        return new ResponseEntity<>(new DataDto<>(newCategory.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(CategoryUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Category category = mapper.fromUpdateDto(updateDto);
        repository.save(category);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.deleteSoft(id);
        return null;
    }


    @Override
    public ResponseEntity<DataDto<CategoryDto>> get(Long id) {
        validator.validateKey(id);
        Category category = repository.getByIdAndNotDeleted(id);
        CategoryDto categoryDto = mapper.toDto(category);
        return new ResponseEntity<>(new DataDto<>(categoryDto));
    }

    @Override
    public ResponseEntity<DataDto<List<CategoryDto>>> getAll(CategoryCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<CategoryDto>>> getAll() {
        List<Category> categories = repository.getAllAndNotDeleted();
        List<CategoryDto> categoryDtos = mapper.toDto(categories);
        return new ResponseEntity<>(new DataDto<>(categoryDtos, (long) categories.size()));
    }


}
