package uz.pdp.warehouse.service.product.product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.product.ProductRepository;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

import java.util.Optional;

@Service
public class ProductCheckService {
    private final ProductRepository repository;

    public ProductCheckService(ProductRepository repository) {
        this.repository = repository;
    }

    public AppErrorDto  checkProductExistence(Long productId) {
            Optional<Product> byId = repository.findById(productId);


        if (byId.isEmpty()) {
            return AppErrorDto.builder()
                    .message("PRODUCT_NOT_FOUND")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return  null;
    }

    public AppErrorDto checkProductExistence(Optional<Product> product) {
        if (product.isEmpty()) {
            return AppErrorDto.builder()
                    .message("PRODUCT_NOT_FOUND")
                    .build();
//            throw new NotFoundException("PRODUCT_NOT_FOUND");
        }
        return  null;
    }
}
