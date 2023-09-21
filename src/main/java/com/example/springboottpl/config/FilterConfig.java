package com.example.springboottpl.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboottpl.filter.LoggingFilter;

/**
 * 描述：jwt过滤器
 * 作者：刘飞华
 * 日期：2023/9/21 12:21
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilter() {
		FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(authFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public LoggingFilter authFilter() {
		return new LoggingFilter();
	}
}
