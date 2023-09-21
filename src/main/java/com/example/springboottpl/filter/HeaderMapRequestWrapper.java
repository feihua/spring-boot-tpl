package com.example.springboottpl.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 描述：设置请求头
 * 作者：刘飞华
 * 日期：2023/9/21 10:08
 */
public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, Object> headerMap = new HashMap<>();

	public HeaderMapRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public void addHeader(String name, Object value) {
		headerMap.put(name, value);
	}

	@Override
	public String getHeader(String name) {
		String headerValue = super.getHeader(name);
		Object value = this.headerMap.get(name);
		if (null != value) {
			return value + "";
		}
		return headerValue;
	}

}
