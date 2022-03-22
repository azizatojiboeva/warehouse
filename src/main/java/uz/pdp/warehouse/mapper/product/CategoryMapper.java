package uz.pdp.warehouse.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.dto.product.category.SubCategoryCreateDto;
import uz.pdp.warehouse.entity.product.Category;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {
    @Override
    CategoryDto toDto(Category entity);

    @Override
    List<CategoryDto> toDto(List<Category> entities);

    @Override
    Category fromCreateDto(CategoryCreateDto createDto);

    @Override
    Category fromUpdateDto(CategoryUpdateDto updateDto);


    Category fromSubCategoryCreateDto(SubCategoryCreateDto subCategoryCreateDto);
}
