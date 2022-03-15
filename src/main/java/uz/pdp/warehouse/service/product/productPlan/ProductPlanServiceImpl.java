package uz.pdp.warehouse.service.product.productPlan;

import uz.pdp.warehouse.dto.product.productPlan.ProductPlanCreateDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanDto;
import uz.pdp.warehouse.dto.product.productPlan.ProductPlanUpdateDto;
import uz.pdp.warehouse.mapper.product.ProductPlanMapper;
import uz.pdp.warehouse.repository.product.ProductPlanRepository;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.ProductPlanValidator;

import java.util.List;

public class ProductPlanServiceImpl extends AbstractService<ProductPlanRepository, ProductPlanMapper, ProductPlanValidator>
        implements ProductPlanService {

    private ProductPlanServiceImpl(ProductPlanMapper mapper,
                                   ProductPlanValidator validator,
                                   ProductPlanRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(ProductPlanCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Boolean update(ProductPlanUpdateDto updateDto) {
        return null;
    }

    @Override
    public ProductPlanDto get(Long id) {
        return null;
    }

    @Override
    public List<ProductPlanDto> getAll(Long id) {
        return null;
    }

    @Override
    public List<ProductPlanDto> getAll() {
        return null;
    }
}
