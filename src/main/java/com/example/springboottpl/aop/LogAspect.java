package com.example.springboottpl.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.util.ExceptionUtil;
import com.example.springboottpl.util.JsonUtil;

/**
 * 描述：切面
 * 作者：刘飞华
 * 日期：2023/5/11 13:49
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

	private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal beginTime");
	// TODO: 2023/9/21 做业务的时候 打开下面注释)
	//private static final ThreadLocal<AuditLogAddReqVo> logThreadLocal = new NamedThreadLocal<>("ThreadLocal log");
	private static final ThreadLocal<String> resultThreadLocal = new NamedThreadLocal<>("ThreadLocal result");

	@Autowired(required = false)
	private HttpServletRequest request;

	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("@annotation(com.example.springboottpl.annotation.OperateLog)")
	public void operateAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作的开始时间
	 *
	 * @param joinPoint 切点
	 *
	 * @author 刘飞华
	 * @date: 2023/5/11 13:46
	 */
	@Before("operateAspect()")
	public void doBefore(JoinPoint joinPoint) {
		Date beginTime = new Date();
		beginTimeThreadLocal.set(beginTime);
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime);
		log.debug("开始计时: {}, URI: {}", format, request.getRequestURI());
	}

	@Around("operateAspect()")
	public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
		Object result = point.proceed();
		resultThreadLocal.set(JsonUtil.toJson(result));
		return result;
	}

	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 *
	 * @param joinPoint 切点
	 * @author 刘飞华
	 * @date: 2023/5/11 14:54
	 */
	@After("operateAspect()")
	public void doAfter(JoinPoint joinPoint) throws Throwable {
		//String userId = request.getHeader("userId");
		//if (StringUtils.isEmpty(userId)) {
		//	return;
		//}

		Object[] args = joinPoint.getArgs();

		String desc = "";
		//String type = "info";                       //日志类型(info:入库,error:错误)
		String remoteAddr = request.getRemoteAddr();//请求的IP
		String requestUri = request.getRequestURI();//请求的Uri
		String method = request.getMethod();        //请求的方法类型(post/get)

		try {
			desc = getControllerMethodDescription(request, joinPoint);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long beginTime = beginTimeThreadLocal.get().getTime();
		long endTime = System.currentTimeMillis();

		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime);
		log.debug(
				"计时结束：{}  URI: {}  耗时： {}   最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
				format, request.getRequestURI(), endTime - beginTime, Runtime.getRuntime().maxMemory() / 1024 / 1024,
				Runtime.getRuntime().totalMemory() / 1024 / 1024, Runtime.getRuntime().freeMemory() / 1024 / 1024,
				(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime()
						.freeMemory()) / 1024 / 1024);

		String result = resultThreadLocal.get();

		log.info("请求参数:{} {} {} {} {} {}", requestUri, method, JsonUtil.toJson(args), desc, result, remoteAddr);

		// TODO: 2023/9/21 添加数据库
		// TODO: 2023/9/21 把数据传到AfterThrowing,出异常的时候更新
		//logThreadLocal.set(logAddReqVo);
	}

	/**
	 * 异常通知
	 *
	 * @param joinPoint joinPoint
	 * @param e e
	 */
	@AfterThrowing(pointcut = "operateAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error(ExceptionUtil.stackTrace(e));
		//e.printStackTrace();
		// TODO: 2023/9/21 获取参数 logThreadLocal.get()
		// TODO: 2023/9/21 提取异常 e
		// TODO: 2023/9/21 更新数据库
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 方法描述
	 * @author 刘飞华
	 * @date: 2023/9/21 16:13
	 */
	public static String getControllerMethodDescription(HttpServletRequest request, JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		OperateLog operateLog = method.getAnnotation(OperateLog.class);
		String desc = operateLog.description();
		if (desc.contains("{")) {
			List<String> list = descFormat(desc);
			for (String s : list) {
				//根据request的参数名获取到参数值，并对注解中的{}参数进行替换
				String value = request.getParameter(s);
				desc = desc.replace("{" + s + "}", value);
			}
		}
		return desc;
	}

	/**
	 * 获取日志信息中的动态参数
	 * @param desc 描述
	 * @return list
	 * @author 刘飞华
	 * @date: 2023/9/21 16:13
	 */
	private static List<String> descFormat(String desc) {
		List<String> list = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
		Matcher matcher = pattern.matcher(desc);
		while (matcher.find()) {
			String t = matcher.group(1);
			list.add(t);
		}
		return list;
	}

}
