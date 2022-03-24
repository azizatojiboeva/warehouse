package uz.pdp.warehouse.controller.product;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserCheckService;
import uz.pdp.warehouse.service.product.product.ProductCheckService;
import uz.pdp.warehouse.service.product.productPlan.ProductPlanService;

import java.util.List;

@RestController
@RequestMapping("/productPlan/")
public class ProductPlanController extends AbstractController<ProductPlanService> {


    public ProductPlanController(ProductPlanService service,
                                 ProductCheckService productCheckService,
                                 AuthUserCheckService authUserCheckService) {
        super(service);
    }

    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody ProductPlanCreateDto productPlanCreateDto) {
        return service.create(productPlanCreateDto);
    }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody ProductPlanUpdateDto productPlanUpdateDto) {

        return service.update(productPlanUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<ProductPlanDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "list/{agentId}")
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAllByAgentId(@PathVariable("agentId") Long agentId) {
        return service.getAllByAgentId(agentId);
    }

}
