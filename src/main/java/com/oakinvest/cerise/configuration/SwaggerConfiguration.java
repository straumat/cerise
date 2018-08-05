package com.oakinvest.cerise.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
     * Rest package.
     */
    private static final String REST_PACKAGE = "com.oakinvest.cerise.web.rest";

    /**
     * Swagger title.
     */
    @Value("${swagger.title}")
    private String title;

    /**
     * Swagger description.
     */
    @Value("${swagger.description}")
    private String description;

    /**
     * Swagger license.
     */
    @Value("${swagger.license}")
    private String license;

    /**
     * Swagger contact name.
     */
    @Value("${swagger.contact.name}")
    private String contactName;

    /**
     * Swagger contact email.
     */
    @Value("${swagger.contact.email}")
    private String contactEmail;

    /**
     * Swagger contact web site.
     */
    @Value("${swagger.contact.website}")
    private String contactWebsite;

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
                .apis(RequestHandlerSelectors.basePackage(REST_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiInfo());
    }

    /**
     * API Information.
     *
     * @return api information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(license)
                .contact(new Contact(contactName, contactWebsite, contactEmail))
                .build();
    }

    @Override
    protected final void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public final void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/docs", "/swagger-ui.html");
        registry.addRedirectViewController("/documentation", "/swagger-ui.html");
        registry.addRedirectViewController("/swagger", "/swagger-ui.html");
    }

}
