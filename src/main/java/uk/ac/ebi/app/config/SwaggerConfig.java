package uk.ac.ebi.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfo("EBI", "REST services", "0.0.1", null,
						new Contact("Anonymous", "http://ebi.ac.uk", null), null, null))
				.select().apis(RequestHandlerSelectors.basePackage("uk.ac.ebi")).build();
	}
}