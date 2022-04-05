package uz.pdp.warehouse.service.rollBack;

import uz.pdp.warehouse.criteria.rollBack.RollBackCriteria;
import uz.pdp.warehouse.dto.rollBack.RollBackCreateDto;
import uz.pdp.warehouse.dto.rollBack.RollBackDto;
import uz.pdp.warehouse.dto.rollBack.RollBackUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.GenericCrudService;

import java.util.List;

public interface RollBackService extends GenericCrudService<RollBackDto, RollBackCreateDto, RollBackUpdateDto, RollBackCriteria,Long> {
    ResponseEntity<DataDto<List<RollBackDto>>> getAllByMarketId(Long id);
}
