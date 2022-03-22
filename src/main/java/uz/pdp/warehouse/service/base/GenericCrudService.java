package uz.pdp.warehouse.service.base;

import uz.pdp.warehouse.criteria.base.BaseCriteria;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

import java.io.Serializable;

/**
 * @param <D>  dto
 * @param <CD> createDto
 * @param <UD> updateDot
 * @param <K>  subject id
 */

public interface GenericCrudService<
        D extends GenericDto,
        CD extends BaseGenericDto,
        UD extends GenericDto,
        C extends BaseCriteria,
        K extends Serializable
        > extends GenericService<D,C, K> {

    ResponseEntity<DataDto<K>> create(CD createDto);

    ResponseEntity<DataDto<Void>> delete(K id);

    ResponseEntity<DataDto<Boolean>> update(UD updateDto);
}