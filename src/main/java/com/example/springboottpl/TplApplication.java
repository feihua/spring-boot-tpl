package com.example.springboottpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述：启动入口
 * 作者：刘飞华
 * 日期：2023/2/22 13:52
 */
@SpringBootApplication
@Slf4j
public class TplApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TplApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String msg = """
                tpl server is running
                
                swagger: http://localhost:6666/tpl/doc.html
                """;
		log.info(msg);
	}
}
