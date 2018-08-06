package com.ctoassociate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ImportResource("applicationContext.xml")
public class CtoassociateApplication implements WebMvcConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(CtoassociateApplication.class);

	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(Arrays.asList("application/json"));

	public static void main(String[] args) {
		SpringApplication.run(CtoassociateApplication.class, args);
		logger.info("********* CTOAssociateService *********");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.ctoassociate.controller")).build()
				.apiInfo(metaData()).produces(DEFAULT_PRODUCES_CONSUMES)
				.consumes(DEFAULT_PRODUCES_CONSUMES);
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("CTO App", "CTO App Rest Service", "1.0",
				"tosUrl", new Contact("CTP App Support", "Support URL",
						"vaibhav.dalavi@ness.com"), "Ness Licence",
				"Ness Licence URL", new ArrayList<>());
		return apiInfo;
	}
	
	
}
