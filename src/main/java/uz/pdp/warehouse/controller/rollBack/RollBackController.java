package uz.pdp.warehouse.controller.rollBack;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.criteria.organization.OrganizationCriteria;
import uz.pdp.warehouse.criteria.rollBack.RollBackCriteria;
import uz.pdp.warehouse.dto.rollBack.RollBackCreateDto;
import uz.pdp.warehouse.dto.rollBack.RollBackDto;
import uz.pdp.warehouse.dto.rollBack.RollBackUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.rollBack.RollBackService;

import java.util.List;

@RestController
@RequestMapping("/rollback/")
public class RollBackController extends AbstractController<RollBackService> {

    public RollBackController(RollBackService service) {
        super(service);
    }

    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody RollBackCreateDto rollBackCreateDto) {
        return service.create(rollBackCreateDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody RollBackUpdateDto rollBackUpdateDto) {
        return service.update(rollBackUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<RollBackDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<RollBackDto>>> getAll(RollBackCriteria criteria) {
        return service.getAll(criteria);
    }

    @GetMapping(value = "list_by_market_id")
    public ResponseEntity<DataDto<List<RollBackDto>>> getAll(Long id) {
        return service.getAllByMarketId(id);
    }


}
