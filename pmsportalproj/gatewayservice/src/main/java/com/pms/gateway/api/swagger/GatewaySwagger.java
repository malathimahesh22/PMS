package com.pms.gateway.api.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


public class GatewaySwagger {

	/*@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().securitySchemes(Lists.newArrayList(apiKey())).apiInfo(apiInfo());

	}

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration("test-app-client-id", "test-app-client-secret", "test-app-realm", "test-app",
				"", ApiKeyVehicle.HEADER, "Authorization", ","  scope separator );
	}

	@Bean
	SecurityScheme apiKey() {
		return new ApiKey("token", "token", "header");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TVS Next - BeyonTec Project")
				.description("BeyonTec Broker Portal Gateway Service with Swagger").version("2.0").build();
	}*/
	
}
