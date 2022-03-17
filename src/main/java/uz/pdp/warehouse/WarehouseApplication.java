package uz.pdp.warehouse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import uz.pdp.warehouse.properties.OpenApiProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(OpenApiProperties.class)
@EnableScheduling
public class WarehouseApplication {

/*
    private final Init init;

    public WarehouseApplication(Init init) {
        this.init = init;
    }
*/


    public static void main(String[] args) throws Exception {
        SpringApplication.run(WarehouseApplication.class, args);
    }







}
