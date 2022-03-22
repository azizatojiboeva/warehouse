package uz.pdp.warehouse.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper extends AbstractMapper<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {
    @Override
    List<ProductDto> toDto(List<Product> entities);

    @Override
    Product fromCreateDto(ProductCreateDto createDto);

    @Override
    Product fromUpdateDto(ProductUpdateDto updateDto);

    @Override
    ProductDto toDto(Product entity);
}
