package com.example.springboottpl.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class TplConfig {

	//不拦截的url
	@Value("#{'${not.intercept.urls}'.split(',')}")
	public List<String> notInterceptUrls;

}
