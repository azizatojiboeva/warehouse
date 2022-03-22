package uz.pdp.warehouse.service.storage;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.storage.StorageCriteria;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.service.base.GenericCrudService;
import uz.pdp.warehouse.service.base.GenericService;

public interface StorageService extends GenericCrudService<StorageDto, StorageCreateDto, StorageUpdateDto, StorageCriteria, Long>{
}
