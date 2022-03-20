package uz.pdp.warehouse.service.product.product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.dto.storage.StorageDto;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.entity.storage.Storage;
import uz.pdp.warehouse.mapper.product.ProductMapper;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.validator.product.ProductValidator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

        // Todo bu yerda product yaratilinsihdan oldin chek service orqali tekshirib olish kerak

        Product product = mapper.fromCreateDto(createDto);
        Product save = repository.save(product);
        if (Objects.nonNull(save)) return new ResponseEntity<>(new DataDto<>(save.getId()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder().message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        UUID uuid = UUID.randomUUID();
        boolean bool = repository.softDelete(id, uuid);
        if (bool) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully deleted").status(HttpStatus.OK).build()));
        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(ProductUpdateDto updateDto) {
        Product product = mapper.fromUpdateDto(updateDto);
        Product save = repository.save(product);

        if (Objects.nonNull(save)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Successfully updated").status(HttpStatus.OK).build()), HttpStatus.OK);


        return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));
    }

    @Override
    public ResponseEntity<DataDto<ProductDto>> get(Long id) {
        Optional<Product> byId = repository.getByIdAndNotDeleted(id);
        if (!byId.isPresent()) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("User not found").status(HttpStatus.NOT_FOUND).build()), HttpStatus.OK);
        Product product = byId.get();
        ProductDto productDto = mapper.toDto(product);

        return new ResponseEntity<>(new DataDto<>(productDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<ProductDto>>> getAll() {

        List<Product> allProducts = repository.getAllAndNotDeleted();

        if (Objects.isNull(allProducts)) return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                .message("Bad Request").status(HttpStatus.BAD_REQUEST).build()));

        List<ProductDto> allProductDtos = mapper.toDto(allProducts);

        return new ResponseEntity<>(new DataDto<>(allProductDtos));
    }
}
