package uz.pdp.warehouse.service.product.category;

import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.mapper.product.CategoryMapper;
import uz.pdp.warehouse.repository.product.CategoryRepository;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.base.BaseGenericService;
import uz.pdp.warehouse.service.base.GenericCrudService;
import uz.pdp.warehouse.validator.product.CategoryValidator;

public interface CategoryService extends GenericCrudService<CategoryDto, CategoryCreateDto, CategoryUpdateDto,Long> {
}
