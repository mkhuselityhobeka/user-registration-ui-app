package com.funda.high.FundaRegistration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.funda.application.ui.controller"))
					.build()
					.apiInfo(getApiInfo());
	}
	
	public ApiInfo getApiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Spring boot REST API", "Leraner Application UI", "1.0",
			    "Used by Students", "Mkhuseli Tyhobeka, email:mkhuselityhobeka@gmail.com", "", "");
		return apiInfo;
	}
}