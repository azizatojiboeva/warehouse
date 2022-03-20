package uz.pdp.warehouse.controller.storage;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.storage.StorageService;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController extends AbstractController<StorageService> {

    public StorageController(StorageService service) {
        super(service);
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<DataDto<List<StorageDto>>> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDto<StorageDto>> get(@RequestParam(name = "id") Long id){
        return service.get(id);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody StorageUpdateDto updateDto){
        return service.update(updateDto);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<DataDto<Long>> create(@RequestBody StorageCreateDto createDto){
        return service.create(createDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@RequestBody Long id){
        return service.delete(id);
    }

}
