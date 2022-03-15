package uz.pdp.warehouse.service.base;

import uz.pdp.warehouse.dto.base.BaseGenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable
        > extends BaseGenericService {

    D get(K id);

    List<D> getAll(K id);
    List<D> getAll();

}