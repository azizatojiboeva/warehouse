package uz.pdp.warehouse.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.service.product.category.CategoryService;
import uz.pdp.warehouse.service.product.category.CategoryServiceImpl;

@RestController
public class CategoryController extends AbstractController<CategoryService> {


    public CategoryController(CategoryService service) {
        super(service);
    }
}
