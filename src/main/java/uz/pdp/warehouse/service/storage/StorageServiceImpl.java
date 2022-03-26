package uz.pdp.warehouse.service.storage;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.storage.StorageCriteria;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.mapper.storage.StorageMapper;
import uz.pdp.warehouse.repository.storage.StorageRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.organization.OrganizationCheckService;
import uz.pdp.warehouse.validator.storage.StorageValidator;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class StorageServiceImpl extends AbstractService<StorageRepository, StorageMapper, StorageValidator> implements StorageService {

    private final StorageCheckService storageCheckService;
    private final OrganizationCheckService organizationCheckService;

    protected StorageServiceImpl(StorageMapper mapper,
                                 StorageValidator validator,
                                 StorageRepository repository,
                                 StorageCheckService storageCheckService, OrganizationCheckService organizationCheckService) {
        super(mapper, validator, repository);
        this.storageCheckService = storageCheckService;
        this.organizationCheckService = organizationCheckService;
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(StorageCreateDto createDto) {
        validator.validOnCreate(createDto);
        organizationCheckService.checkForOrganizationExistence(createDto.getOrganization_id());
        Storage storage = mapper.fromCreateDto(createDto);
        Storage save = repository.save(storage);
        return new ResponseEntity<>(new DataDto<>(save.getId()));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        storageCheckService.checkStoreExists(id);
        UUID uuid = UUID.randomUUID();
        boolean b = repository.softDelete(id, uuid);
        if (b)
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Successfully deleted").status(HttpStatus.OK).build()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
    }


    @Override
    public ResponseEntity<DataDto<Boolean>> update(StorageUpdateDto updateDto) {

        validator.validOnUpdate(updateDto);
        organizationCheckService.checkForOrganizationExistence(updateDto.getOrganization_id());
        storageCheckService.checkStoreExists(updateDto.getId());
        Storage storage = mapper.fromUpdateDto(updateDto);
        Storage save = repository.save(storage);
        if (Objects.nonNull(save))
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Successfully updated").status(HttpStatus.OK).build()), HttpStatus.OK);
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

    }


    @Override
    public ResponseEntity<DataDto<StorageDto>> get(Long id) {

        storageCheckService.checkStoreExists(id);
        Storage storage = repository.getByIdAndNotDeleted(id);
        StorageDto storageDto = mapper.toDto(storage);
        return new ResponseEntity<>(new DataDto<>(storageDto), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll(StorageCriteria criteria) {
        Pageable pageable= PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Storage> all = repository.findAll(pageable).getContent();
        List<StorageDto> storageDtos = mapper.toDto(all);
        return new ResponseEntity<>(new DataDto(storageDtos, (long) storageDtos.size()));
    }


    @Override
    public ResponseEntity<DataDto<List<StorageDto>>> getAll() {
//        List<Storage> storages = repository.getAllAndNotDeleted();
//        if (Objects.isNull(storages)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
//                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
//
//        List<StorageDto> storageDtos = mapper.toDto(storages);
//
//        return new ResponseEntity<>(new DataDto<>(storageDtos));
        return null;
    }


}
