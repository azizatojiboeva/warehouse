package uz.pdp.warehouse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import uz.pdp.warehouse.config.CustomPermissionEvaluator;
import uz.pdp.warehouse.properties.OpenApiProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(OpenApiProperties.class)
@EnableScheduling
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
@RequiredArgsConstructor
public class WarehouseApplication {

//
//    private final Init init;
//
//    public WarehouseApplication(Init init) {
//        this.init = init;
//    }


    private final CustomPermissionEvaluator permissionEvaluator;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(WarehouseApplication.class, args);
    }


    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(permissionEvaluator);
        return handler;
    }


}
