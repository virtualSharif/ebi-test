package uk.ac.ebi.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Maps all Angular routes to index.html so that they work with direct
	 * linking. fixes HTML5 mode pushState
	 */
	@Controller
	static class Routes {
		@RequestMapping({ "/app/**" })
		public String index() {
			return "forward:/index.html";
		}
	}

	public static final String SWAGGER_PATH = "/swagger-ui.html";

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/s", SWAGGER_PATH);
		registry.addRedirectViewController("/swagger", SWAGGER_PATH);
	}

}