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
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.OperationLogService;
import com.example.springboottpl.util.ExceptionUtil;
import com.example.springboottpl.util.JsonUtil;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;

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
	private static final ThreadLocal<OperationLogAddReqVo> logThreadLocal = new NamedThreadLocal<>("ThreadLocal log");

	@Autowired(required = false)
	private HttpServletRequest request;

	@Autowired
	private OperationLogService logService;

	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("@annotation(com.example.springboottpl.annotation.OperateLog)")
	public void operateAspect() {
	}

	@Around("operateAspect()")
	public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
		Date beginTime = new Date();
		String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime);
		log.info("开始计时: {}, URI: {}", startTime, request.getRequestURI());

		String userIdStr = request.getHeader("userId");
		String userName = request.getHeader("userName");

		Object[] args = point.getArgs();

		String desc = "";
		String remoteAddr = request.getRemoteAddr();//请求的IP
		String requestUri = request.getRequestURI();//请求的Uri
		String method = request.getMethod();        //请求的方法类型(post/get)

		try {
			desc = getDesc(request, point);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();

		OperationLogAddReqVo logAddReqVo = new OperationLogAddReqVo();
		if (null != userIdStr && !"".equals(userIdStr)) {
			logAddReqVo.setUserId(Integer.parseInt(userIdStr));
		}
		logAddReqVo.setUserName(userName);
		logAddReqVo.setIpAddress(remoteAddr);
		logAddReqVo.setOperationUrl(requestUri);
		logAddReqVo.setOperationMethod(method);
		logAddReqVo.setOperationDesc(desc);
		logAddReqVo.setRequestParams(JsonUtil.toJson(args));
		logAddReqVo.setResponseParams("error");

		logThreadLocal.set(logAddReqVo);
		Object result = point.proceed();

		logAddReqVo.setResponseParams(JsonUtil.toJson(result));
		logService.saveOperationLog(logAddReqVo);
		return result;
	}

	/**
	 * 异常通知
	 *
	 * @param joinPoint joinPoint
	 * @param e e
	 */
	@AfterThrowing(pointcut = "operateAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		OperationLogAddReqVo result = logThreadLocal.get();
		result.setErrMessage(e.getMessage());
		result.setErrMessageDetail(ExceptionUtil.stackTrace(e));
		logService.saveOperationLog(result);
		log.error("{}-{}", e.getMessage(), ExceptionUtil.stackTrace(e));
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 方法描述
	 * @author 刘飞华
	 * @date: 2023/9/21 16:13
	 */
	public String getDesc(HttpServletRequest request, JoinPoint joinPoint) {
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
