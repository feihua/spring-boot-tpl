package com.example.springboottpl.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 描述：json工具类
 * 作者：刘飞华
 * 日期：2023/9/21 16:54
 */
public class JsonUtil {

	private static Gson gson = new GsonBuilder().create();

	public static String toJson(Object value) {
		return gson.toJson(value);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}

}
