package uz.pdp.warehouse.controller.product;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.product.category.CategoryCreateDto;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.category.CategoryUpdateDto;
import uz.pdp.warehouse.dto.product.category.SubCategoryCreateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.product.category.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category/")
public class CategoryController extends AbstractController<CategoryService> {


    public CategoryController(CategoryService service) {
        super(service);
    }


    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody CategoryCreateDto categoryCreateDto) {
        return service.create(categoryCreateDto);
    }

    @PostMapping(value = "create_sub_category/{id}")
    public ResponseEntity<DataDto<Long>> createSubCategory(@PathVariable("id") Long id,
                                                           @RequestBody SubCategoryCreateDto subCategoryCreateDto) {
        ResponseEntity<DataDto<CategoryDto>> dataDtoResponseEntity = get(id);
        CategoryDto categoryDto = dataDtoResponseEntity.getData().getData();
        subCategoryCreateDto.parentCategory= categoryDto;
        return service.subCategoryCreate(subCategoryCreateDto);
    }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody CategoryUpdateDto categoryUpdateDto) {
        return service.update(categoryUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<CategoryDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<CategoryDto>>> getAll() {
        return service.getAll();
    }


}
