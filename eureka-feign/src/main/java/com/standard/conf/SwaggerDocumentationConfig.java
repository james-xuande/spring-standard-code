package com.standard.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-25T01:24:08.406Z")
@Configuration
public class SwaggerDocumentationConfig {

    private boolean enableSwagger=true;

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("Swagger standard question latest")
                .description("This is a sample standard server. ")
                .license("licence").licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("").version("1.0.0")
                .contact(new Contact("", "", "jiaozongben@gmail.com")).build();
    }


    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.standard")).build().apiInfo(apiInfo()).enable(enableSwagger);
    }
}


