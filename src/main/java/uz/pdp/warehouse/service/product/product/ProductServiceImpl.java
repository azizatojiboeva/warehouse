package uz.pdp.warehouse.service.product.product;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.mapper.product.ProductMapper;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.ProductValidator;

import java.util.List;
@Service
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper, ProductValidator>
        implements ProductService {

    private ProductServiceImpl(ProductMapper mapper,
                               ProductValidator validator,
                               ProductRepository repository) {
        super(mapper, validator, repository);
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(ProductCreateDto createDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<ProductDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll() {
        return null;
    }

}
