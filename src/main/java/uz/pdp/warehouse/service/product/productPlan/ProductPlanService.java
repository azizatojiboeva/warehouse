package uz.pdp.warehouse.service.product.productPlan;

import uz.pdp.warehouse.criteria.product.product.ProductCriteria;
import uz.pdp.warehouse.criteria.product.productPlan.ProductPlanCriteria;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.BaseGenericService;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

public interface ProductPlanService extends GenericCrudService<ProductPlanDto, ProductPlanCreateDto, ProductPlanUpdateDto, ProductPlanCriteria, Long> {
    @Override
    ResponseEntity<DataDto<Long>> create(ProductPlanCreateDto createDto);


    @Override
    ResponseEntity<DataDto<Boolean>> update(ProductPlanUpdateDto updateDto);

    @Override
    ResponseEntity<DataDto<List<ProductPlanDto>>> getAll();

    ResponseEntity<DataDto<List<ProductPlanDto>>> getAllByAgentId(Long agentId);

}
