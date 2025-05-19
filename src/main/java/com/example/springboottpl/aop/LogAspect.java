package com.example.springboottpl.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.OperationLogService;
import com.example.springboottpl.util.ExceptionUtil;
import com.example.springboottpl.util.JsonUtil;
import com.example.springboottpl.vo.req.AddOperationLogReqVo;


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
    private static final ThreadLocal<AddOperationLogReqVo> logThreadLocal = new NamedThreadLocal<>("ThreadLocal log");

    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private OperationLogService logService;

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.example.tpl.system.annotation.OperateLog)")
    public void operateAspect() {
    }

    @Around("operateAspect()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        String requestUri = request.getRequestURI();//请求的Uri
        if (requestUri.contains("queryOperateLogList") || requestUri.contains("queryOperateLogDetail")) {
            return point.proceed();
        }

        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime);
        log.info("开始计时: {}, URI: {}", startTime, request.getRequestURI());

        String userIdStr = request.getHeader("userId");
        String userName = request.getHeader("userName");
        String deptIdStr = request.getHeader("deptId");
        String deptName = request.getHeader("deptName");

        Object[] args = point.getArgs();

        String desc = "";
        String remoteAddr = request.getRemoteAddr();//请求的IP
        //        String requestUri = request.getRequestURI();//请求的Uri
        String method = request.getMethod();        //请求的方法类型(post/get)


        AddOperationLogReqVo logAddReqVo = new AddOperationLogReqVo();
        if (null != userIdStr && !userIdStr.isEmpty()) {
            logAddReqVo.setUserId(Long.parseLong(userIdStr));
        }
        try {
            desc = getDesc(request, point);
            String replace = desc.replace("【", "");
            String title = replace.split("】")[0];
            logAddReqVo.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String userAgentHeader = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentHeader);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        logAddReqVo.setUserName(userName);
        logAddReqVo.setDeptId(Long.parseLong(deptIdStr));
        logAddReqVo.setDeptName(deptName);
        logAddReqVo.setPlatform(operatingSystem.getGroup().getName());
        logAddReqVo.setOs(operatingSystem.getName());
        logAddReqVo.setBrowser(browser.getName());
        logAddReqVo.setVersion(userAgent.getBrowserVersion().getVersion());
        logAddReqVo.setEngine(browser.getRenderingEngine().name());
        logAddReqVo.setOperateIp(remoteAddr);
        logAddReqVo.setOperationUrl(requestUri);
        logAddReqVo.setRequestMethod(method);
        logAddReqVo.setOperationDesc(desc);
        logAddReqVo.setOperateParam(JsonUtil.toJson(args));

        log.info("请求参数: {}", JsonUtil.toJson(args));
        logThreadLocal.set(logAddReqVo);
        Object result = point.proceed();
        log.info("响应参数: {}", JsonUtil.toJson(result));

        logAddReqVo.setJsonResult(JsonUtil.toJson(result));
        logAddReqVo.setStatus(1);


        long endTime = System.currentTimeMillis();
        String endTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime);
        log.info("计时结束: {}, URI: {}  耗时： {}", endTimeStr, request.getRequestURI(), endTime - beginTime.getTime());
        logAddReqVo.setCostTime(endTime - beginTime.getTime());
        logService.addOperationLog(logAddReqVo);
        return result;
    }

    /**
     * 异常通知
     *
     * @param joinPoint joinPoint
     * @param e         e
     */
    @AfterThrowing(pointcut = "operateAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("响应参数: {}", ExceptionUtil.stackTrace(e));

        AddOperationLogReqVo result = logThreadLocal.get();
        result.setErrorMsg(e.getMessage());
        result.setErrMsgDetail(ExceptionUtil.stackTrace(e));

        long endTime = System.currentTimeMillis();
        String endTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime);
        long useTime = endTime - beginTimeThreadLocal.get().getTime();
        log.info("计时结束: {}, URI: {}  耗时： {}", endTimeStr, request.getRequestURI(), useTime);

        result.setStatus(0);
        result.setCostTime(useTime);
        logService.addOperationLog(result);
        log.error("{}-{}", e.getMessage(), ExceptionUtil.stackTrace(e));
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     *
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
     *
     * @param desc 描述
     *
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
