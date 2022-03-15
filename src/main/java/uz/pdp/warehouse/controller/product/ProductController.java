package uz.pdp.warehouse.controller.product;

import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.service.product.category.CategoryService;
import uz.pdp.warehouse.service.product.product.ProductService;

@RestController
public class ProductController  extends AbstractController<ProductService> {


    public ProductController(ProductService service) {
        super(service);
    }
}
