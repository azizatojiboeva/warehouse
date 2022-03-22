package uz.pdp.warehouse.mapper.transaction;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;
import uz.pdp.warehouse.entity.transaction.Transaction;
import uz.pdp.warehouse.mapper.base.AbstractMapper;
import uz.pdp.warehouse.mapper.transaction.transactionElement.TransactionElementMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {TransactionElementMapper.class})
public interface TransactionMapper extends AbstractMapper<Transaction, TransactionDto, TransactionCreateDto, TransactionUpdateDto> {

    @Override
    TransactionDto toDto(Transaction entity);

    @Override
    List<TransactionDto> toDto(List<Transaction> entities);

    @Override
    Transaction fromCreateDto(TransactionCreateDto createDto);

    @Override
    Transaction fromUpdateDto(TransactionUpdateDto updateDto);
}
