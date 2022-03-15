package uz.pdp.warehouse.controller.product;

import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.service.product.category.CategoryService;
import uz.pdp.warehouse.service.product.productPlan.ProductPlanService;

@RestController
public class ProductPlanController extends AbstractController<ProductPlanService> {

    public ProductPlanController(ProductPlanService service) {
        super(service);
    }
}
