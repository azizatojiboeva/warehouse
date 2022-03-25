package uz.pdp.warehouse.service.storage;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.storage.StorageRepository;

import java.util.Optional;

@Service
public class StorageCheckService {

    StorageRepository repository;

    public void checkStoreExists(Long id){
        Optional<Storage> byId = repository.findById(id);
        if (byId.isEmpty()){
            throw new NotFoundException("STORAGE_NOT_FOUND");
        }
    }

}
