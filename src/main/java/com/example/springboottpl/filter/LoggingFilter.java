package com.example.springboottpl.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化方法
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getMethod();
		String queryString = httpServletRequest.getQueryString();
		String remoteAddr = httpServletRequest.getRemoteAddr();

		System.out.println("LoggingFilter - " + requestURI + " " + method + " " + queryString + " " + remoteAddr);

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// 销毁方法
	}
}

