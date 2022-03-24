package uz.pdp.warehouse.service.product.productPlan;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.product.productPlan.ProductPlanCriteria;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.entity.product.ProductPlan;
import uz.pdp.warehouse.exception.auth.AuthUserCheckException;
import uz.pdp.warehouse.exception.product.ProductCheckException;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.mapper.product.ProductPlanMapper;
import uz.pdp.warehouse.repository.product.ProductPlanRepository;
import uz.pdp.warehouse.response.AppErrorDto;
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
        try {
            authUserCheckService.checkProductExistence(createDto.agentId);
            productCheckService.checkProductExistence(createDto.product.getId());
            validator.validOnCreate(createDto);
        } catch (AuthUserCheckException a) {
            return new ResponseEntity<>(
                    new DataDto<>(AppErrorDto.builder()
                            .message("USER_NOT_FOUND")
                            .status(HttpStatus.NOT_FOUND)
                            .build()));
        } catch (ProductCheckException p) {
            return new ResponseEntity<>(
                    new DataDto<>(AppErrorDto.builder()
                            .message("PRODUCT_NOT_FOUND")
                            .status(HttpStatus.NOT_FOUND)
                            .build()));
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build()));
        }
        ProductPlan productPlan = mapper.fromCreateDto(createDto);
        ProductPlan newProductPlan = repository.save(productPlan);
        return new ResponseEntity<>(new DataDto<>(newProductPlan.getId()));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        try {
            validator.validateKey(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build()));
        }
        repository.softDelete(id);
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductPlanUpdateDto updateDto) {
        try {
            productCheckService.checkProductExistence(updateDto.product.getId());
            validator.validOnUpdate(updateDto);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build()));
        } catch (ProductCheckException p) {
            return new ResponseEntity<>(
                    new DataDto<>(AppErrorDto.builder()
                            .message("PRODUCT_NOT_FOUND")
                            .status(HttpStatus.NOT_FOUND)
                            .build()));
        }
        ProductPlan productPlan = mapper.fromUpdateDto(updateDto);
        repository.save(productPlan);
        return new ResponseEntity<>(new DataDto<>(Boolean.TRUE));
    }


    @Override
    public ResponseEntity<DataDto<ProductPlanDto>> get(Long id) {
        try {
            validator.validateKey(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage())
                    .build()));
        }
        ProductPlan productPlan = repository.getByIdAndNotDeleted(id);
        ProductPlanDto productPlanDto = mapper.toDto(productPlan);
        return new ResponseEntity<>(new DataDto<>(productPlanDto));
    }

    @Override
    public ResponseEntity<DataDto<List<ProductPlanDto>>> getAll(ProductPlanCriteria criteria) {
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
