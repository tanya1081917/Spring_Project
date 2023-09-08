package com.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
  @Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.spring.project"))
				.build()
				.apiInfo(apiCustomData());
	}

	 private ApiInfo apiCustomData()
	 {
		 return new ApiInfo(
				 "cloud Vendor API Application",
				 "Cloud vendor documetation",
				 "1.0",
				 "cloud vendor service terms",
				 new Contact("Tanya","http:fkjsf","dsfjksfj@jhsfd.com"),
				 "License" ,
				 "afsdf",
				 Collections.emptyList()
		 );
	 }


}
