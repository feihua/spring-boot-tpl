package com.example.springboottpl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

	@Bean(value = "defaultApi2")
	public Docket defaultApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("swagger-bootstrap-ui-demo RESTful APIs")
						.description("# swagger-bootstrap-ui-demo RESTful APIs")
						.termsOfServiceUrl("http://www.xx.com/")
						.contact(new Contact("liufeihua","http://www.liufeihua.com","1002219331@qq.com"))
						.version("1.0")
						.build())
				.groupName("基础服务")
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}
}