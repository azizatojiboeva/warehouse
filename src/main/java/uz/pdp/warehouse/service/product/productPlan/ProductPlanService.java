package uz.pdp.warehouse.service.product.productPlan;

import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.service.base.BaseGenericService;
import uz.pdp.warehouse.service.base.GenericCrudService;

public interface ProductPlanService extends GenericCrudService<ProductPlanDto, ProductPlanCreateDto, ProductPlanUpdateDto, Long> {
}
