package uz.pdp.warehouse.controller.organization;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.organization.OrganizationCreateDto;
import uz.pdp.warehouse.dto.organization.OrganizationDto;
import uz.pdp.warehouse.dto.organization.OrganizationUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.organization.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/organization/")
public class OrganizationController extends AbstractController<OrganizationService> {
    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody OrganizationCreateDto organizationCreateDto) {
        return service.create(organizationCreateDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody OrganizationUpdateDto organizationUpdateDto) {
        return service.update(organizationUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<OrganizationDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<OrganizationDto>>> getAll() {
        return service.getAll();
    }


}
