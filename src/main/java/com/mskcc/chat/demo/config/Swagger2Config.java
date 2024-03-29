package com.mskcc.chat.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Swagger2Config program implements Swagger ui documentation TO - DO - not
 * complete.
 * 
 * @author Smitha Chap
 * @version 1.0
 * @since 2019-09-02
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("CHAT Web Application - Spring Boot REST API")
				.description("CHAT WEB REST API")
				.contact(new Contact("Smitha Chaparala", "GIT URL", "csmitha09@gmail.com")).version("1.0.0").build();
	}

}