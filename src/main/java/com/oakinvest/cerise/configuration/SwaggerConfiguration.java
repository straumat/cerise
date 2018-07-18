package com.oakinvest.cerise.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration.
 *
 * @author straumat
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    /**
     * API Creation.
     *
     * @return api
     */
    @Bean
    @SuppressWarnings("checkstyle:designforextension")
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.oakinvest.cerise.web.rest"))
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiInfo());
    }

    /**
     * API Information.
     *
     * @return api information.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cerise (BIP171)")
                .description("A common interface for requesting currency exchange rate information from a server - BIP171 implementation")
                .version("0.1")
                .license("BSD 2-Clause License")
                .licenseUrl("https://raw.githubusercontent.com/straumat/cerise/master/LICENSE")
                .contact(new Contact("Stéphane Traumat", "https://github.com/straumat/cerise", "stephane.traumat@gmail.com"))
                .build();
    }

    @Override
    protected final void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
