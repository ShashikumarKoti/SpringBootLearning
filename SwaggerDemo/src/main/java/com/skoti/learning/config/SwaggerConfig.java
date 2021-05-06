package com.skoti.learning.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket studentAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.skoti.learning.controller"))
				.build()
				.globalOperationParameters(Arrays.asList(new ParameterBuilder()
						.name("Token")
						.description("Generated token")
						.modelRef(new ModelRef("string"))
						.parameterType("header")
						.required(true)
						.build(),
						new ParameterBuilder()
						.name("Service Name")
						.description("Service Name")
						.modelRef(new ModelRef("string"))
						.parameterType("header")
						.required(true)
						.build()
						));
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Student Swagger Page")
				.description("Student operations in detail")
				.version("1.0")
				.build();
	}
}
