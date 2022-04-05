package uz.pdp.warehouse.mapper.rollBack;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.rollBack.RollBackCreateDto;
import uz.pdp.warehouse.dto.rollBack.RollBackDto;
import uz.pdp.warehouse.dto.rollBack.RollBackUpdateDto;
import uz.pdp.warehouse.entity.rollback.Rollback;
import uz.pdp.warehouse.mapper.base.AbstractMapper;
import uz.pdp.warehouse.mapper.product.ProductMapper;
import uz.pdp.warehouse.mapper.transaction.TransactionMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {TransactionMapper.class, ProductMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RollBackMapper extends AbstractMapper<Rollback, RollBackDto, RollBackCreateDto, RollBackUpdateDto> {
    @Override
    RollBackDto toDto(Rollback entity);

    @Override
    List<RollBackDto> toDto(List<Rollback> entities);

    @Override
    Rollback fromCreateDto(RollBackCreateDto createDto);

    Rollback fromUpdateDto(RollBackUpdateDto updateDto, @MappingTarget Rollback rollBack);
}
