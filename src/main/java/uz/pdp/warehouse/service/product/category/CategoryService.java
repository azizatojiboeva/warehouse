package uz.pdp.warehouse.service.product.category;

import uz.pdp.warehouse.criteria.product.category.CategoryCriteria;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.dto.product.category.SubCategoryCreateDto;
import uz.pdp.warehouse.mapper.product.CategoryMapper;
import uz.pdp.warehouse.repository.product.CategoryRepository;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.base.BaseGenericService;
import uz.pdp.warehouse.service.base.GenericCrudService;
import uz.pdp.warehouse.validator.product.CategoryValidator;

import java.util.List;

public interface CategoryService extends GenericCrudService<CategoryDto, CategoryCreateDto, CategoryUpdateDto, CategoryCriteria,Long> {
    @Override
    ResponseEntity<DataDto<Long>> create(CategoryCreateDto createDto);


    @Override
    ResponseEntity<DataDto<Boolean>> update(CategoryUpdateDto updateDto);

    @Override
    ResponseEntity<DataDto<List<CategoryDto>>> getAll();

    ResponseEntity<DataDto<Long>> subCategoryCreate(SubCategoryCreateDto subCategoryCreateDto);
}

