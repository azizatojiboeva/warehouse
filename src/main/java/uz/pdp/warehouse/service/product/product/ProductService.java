package uz.pdp.warehouse.service.product.product;


import uz.pdp.warehouse.criteria.product.product.ProductCriteria;
import uz.pdp.warehouse.dto.product.product.ProductCreateDto;
import uz.pdp.warehouse.dto.product.product.ProductDto;
import uz.pdp.warehouse.dto.product.product.ProductUpdateDto;
import uz.pdp.warehouse.service.base.GenericCrudService;

public interface ProductService extends GenericCrudService<ProductDto, ProductCreateDto, ProductUpdateDto, ProductCriteria, Long> {

}
