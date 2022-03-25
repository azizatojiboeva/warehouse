package uz.pdp.warehouse.service.product.productPlan;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.product.productPlan.ProductPlanCriteria;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.entity.product.ProductPlan;
import uz.pdp.warehouse.mapper.product.ProductPlanMapper;
import uz.pdp.warehouse.repository.product.ProductPlanRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserCheckService;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.product.product.ProductCheckService;
import uz.pdp.warehouse.validator.product.ProductPlanValidator;

import java.util.List;

@Service
public class ProductPlanServiceImpl extends AbstractService<ProductPlanRepository, ProductPlanMapper, ProductPlanValidator>
        implements ProductPlanService {

    private final ProductCheckService productCheckService;
    private final AuthUserCheckService authUserCheckService;


    private ProductPlanServiceImpl(ProductPlanMapper mapper,
                                   ProductPlanValidator validator,
                                   ProductPlanRepository repository,
                                   ProductCheckService productCheckService,
                                   AuthUserCheckService authUserCheckService) {
        super(mapper, validator, repository);
        this.productCheckService = productCheckService;
        this.authUserCheckService = authUserCheckService;
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(ProductPlanCreateDto createDto) {
        validator.validOnCreate(createDto);
        authUserCheckService.checkProductExistence(createDto.agentId);
        productCheckService.checkProductExistence(createDto.product.getId());
        ProductPlan productPlan = mapper.fromCreateDto(createDto);
        ProductPlan newProductPlan = repository.save(productPlan);
        return new ResponseEntity<>(new DataDto<>(newProductPlan.getId()));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        validator.validateKey(id);
        repository.softDelete(id);
        return new ResponseEntity<>(new DataDto<>(null));
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductPlanUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        productCheckService.checkProductExistence(updateDto.product.getId());
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
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAll(ProductPlanCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<ProductPlan> productPlans = repository.findAll(pageable).getContent();
        List<ProductPlanDto> productPlanDtos = mapper.toDto(productPlans);
        return new ResponseEntity<>(new DataDto<>(productPlanDtos, (long) productPlanDtos.size()));
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
        authUserCheckService.checkProductExistence(agentId);
        List<ProductPlan> productPlans = repository.getAllAndByAgentId(agentId);
        List<ProductPlanDto> productPlanDtos = mapper.toDto(productPlans);
        return new ResponseEntity<>(new DataDto<>(productPlanDtos, (long) productPlanDtos.size()));
    }
}
