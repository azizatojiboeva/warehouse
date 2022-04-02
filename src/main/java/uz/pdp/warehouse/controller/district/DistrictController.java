package uz.pdp.warehouse.controller.district;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.district.DistrictCreateDto;
import uz.pdp.warehouse.dto.district.DistrictDto;
import uz.pdp.warehouse.dto.district.DistrictUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.district.DistrictService;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 2:04 PM,3/17/2022
 */
@Slf4j
@RestController
@RequestMapping("/district/")
public class DistrictController extends AbstractController<DistrictService> {


    public DistrictController(DistrictService service) {
        super(service);
    }


    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody DistrictCreateDto dto) {
        log.info("DistrictCreate {}", dto);
        return service.create(dto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody DistrictUpdateDto dto) {
        return service.update(dto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<DistrictDto>> get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @PreAuthorize(value ="hasPermission('hassAccess','ALL_DISTRICTS')")
    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<DistrictDto>>> getAll(){
        log.info("Get all ");
        return service.getAll();
    }

}
