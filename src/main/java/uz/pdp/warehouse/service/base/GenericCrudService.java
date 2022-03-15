package uz.pdp.warehouse.service.base;

import team.concurrency.mealproject.dto.base.BaseGenericDto;
import team.concurrency.mealproject.dto.base.GenericDto;

import java.io.Serializable;

public interface GenericCrudService<
        D extends GenericDto,
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable
        > extends GenericService<D, K> {

    K create(CD createDto);

    void delete(K id);

    Boolean update(UD updateDto);
}