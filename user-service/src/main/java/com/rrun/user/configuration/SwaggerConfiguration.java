package com.rrun.user.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket userServiceApiDock() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rrun.user")).build().apiInfo(metaData());
	}
	
	public ApiInfo metaData() {
		return new ApiInfo("User-Service", "This Document contains the register service api", "1.0", "urn:tos",
				new Contact("RUN RY", "URL", "ry.run007@gmail.com"), "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	}
}
