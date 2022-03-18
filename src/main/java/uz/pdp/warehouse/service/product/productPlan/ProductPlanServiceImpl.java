package uz.pdp.warehouse.service.product.productPlan;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.entity.product.ProductPlan;
import uz.pdp.warehouse.mapper.product.ProductPlanMapper;
import uz.pdp.warehouse.repository.product.ProductPlanRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.ProductPlanValidator;

import java.util.List;

@Service
public class ProductPlanServiceImpl extends AbstractService<ProductPlanRepository, ProductPlanMapper, ProductPlanValidator>
        implements ProductPlanService {

    private ProductPlanServiceImpl(ProductPlanMapper mapper,
                                   ProductPlanValidator validator,
                                   ProductPlanRepository repository) {
        super(mapper, validator, repository);
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(ProductPlanCreateDto createDto) {
        validator.validOnCreate(createDto);
        ProductPlan productPlan = mapper.fromCreateDto(createDto);
        ProductPlan newProductPlan = repository.save(productPlan);
        return new ResponseEntity<>(new DataDto<>(newProductPlan.getId()));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.softDelete(id);
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductPlanUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        ProductPlan productPlan = mapper.fromUpdateDto(updateDto);
        repository.save(productPlan);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }


    @Override
    public ResponseEntity<DataDto<ProductPlanDto>> get(Long id) {
        validator.validateKey(id);
        ProductPlan productPlan = repository.getByIdAndNotDeleted(id);
        ProductPlanDto productPlanDto = mapper.toDto(productPlan);
        return new ResponseEntity<>(new DataDto<>(productPlanDto));
    }

    @Override
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAll() {
        List<ProductPlan> productPlans = repository.getAllAndNotDeleted();
        List<ProductPlanDto> productPlanDtos = mapper.toDto(productPlans);
        return new ResponseEntity<>(new DataDto<>(productPlanDtos, (long) productPlanDtos.size()));
    }

    @Override
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAllByAgentId(Long agentId) {
        validator.validateKey(agentId);
        List<ProductPlan> productPlans = repository.getAllAndByAgentId(agentId);
        List<ProductPlanDto> productPlanDtos = mapper.toDto(productPlans);
        return new ResponseEntity<>(new DataDto<>(productPlanDtos, (long) productPlanDtos.size()));
    }
}
