package com.service.customer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

//    @Value("${info.app.version}")
//    private String appVersion;

    @Bean
    public OpenAPI customCofiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer API")
                        .description("Outdoors Services")
//                        .version(appVersion)
                        .license(new License()
                                .name("")
                                .url("http://unlicense.org")));
    }
}
