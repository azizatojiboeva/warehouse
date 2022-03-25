package uz.pdp.warehouse.service.product.product;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.product.Product;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.product.ProductRepository;

import java.util.Optional;

@Service
public class ProductCheckService {
    private final ProductRepository repository;

    public ProductCheckService(ProductRepository repository) {
        this.repository = repository;
    }

    public void checkProductExistence(Long productId) {
        Optional<Product> byId = repository.findById(productId);
        if (byId.isEmpty()){
            throw new NotFoundException("PRODUCT_NOT_FOUND");
        }
    }
}
