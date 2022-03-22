package uz.pdp.warehouse.mapper.transaction.transactionElement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TransactionElementMapper extends AbstractMapper<TransactionElement, TransactionElementDto, TransactionElementCreateDto, TransactionElementUpdateDto> {
    @Override
    TransactionElementDto toDto(TransactionElement entity);

    @Override
    List<TransactionElementDto> toDto(List<TransactionElement> entities);

    @Override
    TransactionElement fromCreateDto(TransactionElementCreateDto createDto);

    @Override
    TransactionElement fromUpdateDto(TransactionElementUpdateDto updateDto);
}
