package uz.pdp.warehouse.mapper.storage;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.storage.StorageCreateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.dto.storage.StorageUpdateDto;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface StorageMapper extends AbstractMapper<Storage, StorageDto, StorageCreateDto, StorageUpdateDto> {



}
