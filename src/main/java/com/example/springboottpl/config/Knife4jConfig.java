package com.example.springboottpl.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder().group("default").pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info().title("基础系统API").version("1.0").description("基于RBAC的权限角色管理系统")
                        .contact(new Contact().name("刘飞华"))
                        .license(new License().name("Apache 2.0")));
    }
}