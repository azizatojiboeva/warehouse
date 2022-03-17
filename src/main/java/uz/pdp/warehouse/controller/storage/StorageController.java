package uz.pdp.warehouse.controller.storage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.service.storage.StorageService;

@RestController
@RequestMapping("/")
public class StorageController extends AbstractController<StorageService> {

    public StorageController(StorageService service) {
        super(service);
    }
}
