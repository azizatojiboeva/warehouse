package uz.pdp.warehouse.controller.market;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.market.MarketCreateDto;
import uz.pdp.warehouse.dto.market.MarketDto;
import uz.pdp.warehouse.dto.market.MarketUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.market.MarketServiceImpl;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Fri 12:24 AM,3/18/2022
 */
@RestController
@RequestMapping("/market/")
public class MarketController extends AbstractController<MarketServiceImpl> {
    public MarketController(MarketServiceImpl service) {
        super(service);
    }

    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody MarketCreateDto dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<MarketDto>> get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody MarketUpdateDto dto) {
        return service.update(dto);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<MarketDto>>> getAll() {
        return service.getAll();
    }


}
