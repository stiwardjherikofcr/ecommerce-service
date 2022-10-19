package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo() {
        return new Info()
                .title("Ecommerce API")
                .description("API para el manejo de productos y ventas")
                .version("v1.0.0")
                .license(new License()
                        .name("Apache License, Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact()
                        .name("Frey Marin Ochoa Guevata")
                        .url("https://github.com/freyochoa")
                        .email("fmo8@hotmail.com"))
                .termsOfService("https://misiontic2022.unab.edu.co/");
    }

}
