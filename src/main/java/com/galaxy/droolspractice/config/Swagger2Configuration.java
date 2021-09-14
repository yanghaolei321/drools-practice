package com.galaxy.droolspractice.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 配置
 *
 * @author yanghaolei
 * @date 9/14/21 7:18 PM
 */

@Configuration
@EnableSwagger2
public class Swagger2Configuration {


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build();
    }

    /**
     * Api Info
     *
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("LinChe的接口文档")
            .description("Drools-Practice 相关接口的文档")
            .termsOfServiceUrl("http://localhost:8081/hello")
            .version("1.0")
            .build();
    }

}
