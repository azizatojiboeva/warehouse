package uz.pdp.warehouse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.pdp.warehouse.properties.OpenApiProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(OpenApiProperties.class)
public class WarehouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }
}
