package uz.pdp.warehouse.service.product.product;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.criteria.product.product.ProductCriteria;
import uz.pdp.warehouse.dto.product.category.CategoryDto;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.transaction.TransactionElement;
import uz.pdp.warehouse.mapper.product.ProductMapper;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.product.category.CategoryCheckService;
import uz.pdp.warehouse.validator.product.ProductValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper, ProductValidator>
        implements ProductService {

    private final ProductCheckService productCheckService;
    private final CategoryCheckService categoryCheckService;


    private ProductServiceImpl(ProductMapper mapper,
                               ProductValidator validator,
                               ProductRepository repository,
                               ProductCheckService productCheckService,
                               CategoryCheckService categoryCheckService) {
        super(mapper, validator, repository);
        this.productCheckService = productCheckService;
        this.categoryCheckService = categoryCheckService;
    }


    @Override
    public ResponseEntity<DataDto<Long>> create(ProductCreateDto createDto) {

        // TODO Category null kelishi ham mumkin agar category null bo'lmasa databaseda bor yoki yo'q ligini tekshirishkerak

        AppErrorDto errorDto = checkFields(createDto.getCategory());
        if (Objects.nonNull(errorDto)) {
            return new ResponseEntity<>(new DataDto<>(errorDto));
        }
        validator.validOnCreate(createDto);
        Product product = mapper.fromCreateDto(createDto);
        Product save = repository.save(product);
        if (Objects.nonNull(save))
            return new ResponseEntity<>(new DataDto<>(save.getId()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("BAD_REQUEST").status(HttpStatus.BAD_REQUEST).build()));
    }


    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {

        productCheckService.checkProductExistence(id);
        UUID uuid = UUID.randomUUID();
        boolean bool = repository.softDelete(id, uuid);
        if (bool)
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Successfully deleted").status(HttpStatus.OK).build()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

    }


    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductUpdateDto updateDto) {

        validator.validOnUpdate(updateDto);
        productCheckService.checkProductExistence(updateDto.getId());
        Product product = mapper.fromUpdateDto(updateDto);
        Product save = repository.save(product);
        if (Objects.nonNull(save)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully updated").status(HttpStatus.OK).build()), HttpStatus.OK);
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("SOME_THING_WENT_WRONG_NOT_UPDATE").status(HttpStatus.BAD_REQUEST).build()));
    }


    @Override
    public ResponseEntity<DataDto<ProductDto>> get(Long id) {

       AppErrorDto errorChek = productCheckService.checkProductExistence(id);
       if(Objects.nonNull(errorChek)) return new ResponseEntity<>(new DataDto<>(errorChek));
        Optional<Product> byId = repository.getByIdAndNotDeleted(id);
        if (byId.isEmpty()) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("User not found").status(HttpStatus.NOT_FOUND).build()), HttpStatus.OK);
        Product product = byId.get();
        ProductDto productDto = mapper.toDto(product);
        return new ResponseEntity<>(new DataDto<>(productDto), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll(ProductCriteria criteria) {
        Pageable pageable= PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Product> all = repository.findAll(pageable).getContent();
        List<ProductDto> productDtos = mapper.toDto(all);
        return new ResponseEntity<>(new DataDto(productDtos, (long) productDtos.size()));
    }


    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll() {
//        List<Product> allProducts = repository.getAllAndNotDeleted();
//        if (Objects.isNull(allProducts))
//            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
//        List<ProductDto> allProductDtos = mapper.toDto(allProducts);
//        return new ResponseEntity<>(new DataDto<>(allProductDtos));
        return null;
    }

    private AppErrorDto checkFields(List<CategoryDto> categories) {
        for (CategoryDto category : categories) {
            categoryCheckService.checkCategoryExistence(category.getId());
        }
        return null;
    }
}
