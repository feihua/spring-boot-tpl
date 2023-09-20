package com.example.springboottpl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 描述：swagger接口文档配置
 * 作者：刘飞华
 * 日期：2023/2/22 14:31
 */
@Configuration
public class SwaggerConfig {

	/**
	 * 配置基本信息
	 *
	 * @return ApiInfo
	 * @author 刘飞华
	 * @date: 2023/2/22 14:31
	 */
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Test App Restful API").description("swagger test app restful api")
				.termsOfServiceUrl("https://github.com/feihua")
				.contact(new Contact("koobe", "https://www.test.net", "1002219331@qq.com")).version("1.0").build();
	}

	/**
	 * 配置文档生成最佳实践
	 *
	 * @return Docket
	 * @author 刘飞华
	 * @date: 2023/2/22 14:31
	 */
	@Bean
	public Docket createRestApi(ApiInfo apiInfo) {
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo).groupName("SwaggerGroupOneAPI").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build();
	}

}