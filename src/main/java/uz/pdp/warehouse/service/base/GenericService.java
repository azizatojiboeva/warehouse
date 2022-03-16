package uz.pdp.warehouse.service.base;

import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable
        > extends BaseGenericService {

    ResponseEntity<DataDto<D>> get(K id);

    ResponseEntity<DataDto<List<D>>> getAll(K id);

    ResponseEntity<DataDto<List<D>>> getAll();

}