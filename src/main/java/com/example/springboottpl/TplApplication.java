package com.example.springboottpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 描述：启动入口
 * 作者：刘飞华
 * 日期：2023/2/22 13:52
 */
@EnableOpenApi
@SpringBootApplication
public class TplApplication {

	public static void main(String[] args) {
		SpringApplication.run(TplApplication.class, args);
	}

}
