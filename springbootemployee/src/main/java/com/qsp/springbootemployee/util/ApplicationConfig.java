package com.qsp.springbootemployee.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	// url-->http://localhost:8080/swagger-ui.html#
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Q Spiders", "https://qspiders.com", "qspiders@gmail.com");

		List<VendorExtension> extensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("Employee Management", "used to manage the details of the employee",
				"Version 1.0", "1 year of free service", contact, "www.ems.com", "www.ems.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springbootemployee")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}
