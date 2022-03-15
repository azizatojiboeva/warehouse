package uz.pdp.warehouse.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.entity.product.ProductPlan;
import uz.pdp.warehouse.mapper.base.AbstractMapper;
import uz.pdp.warehouse.mapper.base.BaseGenericMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductPlanMapper extends AbstractMapper<ProductPlan, ProductPlanDto, ProductPlanCreateDto, ProductPlanUpdateDto> {
    @Override
    ProductPlanDto toDto(ProductPlan entity);

    @Override
    List<ProductPlanDto> toDto(List<ProductPlan> entities);

    @Override
    ProductPlan fromCreateDto(ProductPlanCreateDto createDto);

    @Override
    ProductPlan fromUpdateDto(ProductPlanUpdateDto updateDto);
}
