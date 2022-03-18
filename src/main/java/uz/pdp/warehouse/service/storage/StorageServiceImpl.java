package uz.pdp.warehouse.service.storage;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.mapper.storage.StorageMapper;
import uz.pdp.warehouse.repository.storage.StorageRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.storage.StorageValidator;

import java.util.List;
@Service
public class StorageServiceImpl extends AbstractService<StorageRepository, StorageMapper, StorageValidator> implements StorageService {

    protected StorageServiceImpl(StorageMapper mapper, StorageValidator validator, StorageRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(StorageCreateDto createDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(StorageUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<StorageDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll() {
        return null;
    }
}
