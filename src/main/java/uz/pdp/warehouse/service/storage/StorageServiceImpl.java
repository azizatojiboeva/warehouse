package uz.pdp.warehouse.service.storage;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.storage.StorageCriteria;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.mapper.storage.StorageMapper;
import uz.pdp.warehouse.repository.storage.StorageRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.storage.StorageValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StorageServiceImpl extends AbstractService<StorageRepository, StorageMapper, StorageValidator> implements StorageService {

    protected StorageServiceImpl(StorageMapper mapper, StorageValidator validator, StorageRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public ResponseEntity<DataDto<Long>> create(StorageCreateDto createDto) {
        validator.validOnCreate(createDto);
        Storage storage = mapper.fromCreateDto(createDto);
        Storage save = repository.save(storage);
        return new ResponseEntity<>(new DataDto<>(save.getId()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        UUID uuid = UUID.randomUUID();
        boolean b = repository.softDelete(id, uuid);
        if (b) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully deleted").status(HttpStatus.OK).build()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(StorageUpdateDto updateDto) {
        Storage storage = mapper.fromUpdateDto(updateDto);
        Storage save = repository.save(storage);

        if (Objects.nonNull(save)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully updated").status(HttpStatus.OK).build()), HttpStatus.OK);


        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

    }

    @Override
    public ResponseEntity<DataDto<StorageDto>> get(Long id) {

        Optional<Storage> byId = repository.getByIdAndNotDeleted(id);
        if (!byId.isPresent()) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("User not found").status(HttpStatus.NOT_FOUND).build()), HttpStatus.OK);
        Storage storage = byId.get();
        StorageDto storageDto = mapper.toDto(storage);

        return new ResponseEntity<>(new DataDto<>(storageDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll(StorageCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll() {
        List<Storage> storages = repository.getAllAndNotDeleted();
        if (Objects.isNull(storages)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

        List<StorageDto> storageDtos = mapper.toDto(storages);

        return new ResponseEntity<>(new DataDto<>(storageDtos));
    }
}
