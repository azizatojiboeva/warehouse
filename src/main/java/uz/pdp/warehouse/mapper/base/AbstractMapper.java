package uz.pdp.warehouse.mapper.base;

import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.entity.base.BaseEntity;

import java.util.List;

public interface AbstractMapper<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseGenericDto,
        UP extends GenericDto
        > extends BaseGenericMapper {


    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E fromCreateDto(CD createDto);

    E fromUpdateDto(UP updateDto);
}
