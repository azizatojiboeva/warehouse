package uz.pdp.warehouse.service.product.product;

import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.mapper.product.ProductMapper;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.ProductValidator;

import java.util.List;

public class ProjectServiceImpl extends AbstractService<ProductRepository, ProductMapper, ProductValidator>
        implements ProductService {

    private ProjectServiceImpl(ProductMapper mapper,
                               ProductValidator validator,
                               ProductRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(ProductCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Boolean update(ProductUpdateDto updateDto) {
        return null;
    }

    @Override
    public ProductDto get(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAll(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }
}
