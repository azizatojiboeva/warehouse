package uz.pdp.warehouse.controller.product;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;

import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

import uz.pdp.warehouse.service.product.product.ProductService;

import java.util.List;

@RestController("/product")
//@RequestMapping
public class ProductController  extends AbstractController<ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<DataDto<List<ProductDto>>> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDto<ProductDto>> get(@RequestParam(name = "id") Long id){
        return service.get(id);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody ProductUpdateDto updateDto){
        return service.update(updateDto);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<DataDto<Long>> create(@RequestBody ProductCreateDto createDto){
        return service.create(createDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@RequestBody Long id){
        return service.delete(id);
    }

}
