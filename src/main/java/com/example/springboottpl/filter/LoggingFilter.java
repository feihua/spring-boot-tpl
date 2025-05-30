package com.example.springboottpl.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.config.TplConfig;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.TplConstant;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
@Slf4j
public class LoggingFilter implements Filter {

    @Autowired
    private TplConfig tplConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String requestURI = servletRequest.getRequestURI();
        String method = servletRequest.getMethod();
        String queryString = servletRequest.getQueryString();
        String remoteAddr = servletRequest.getRemoteAddr();

        log.info("LoggingFilter - {} {} {} {}", requestURI, method, queryString, remoteAddr);

        if (tplConfig.notInterceptUrls.contains(requestURI) || requestURI.contains("webjars") || requestURI.contains("api-docs")) {
            chain.doFilter(request, response);
            return;
        }

        checkAuthorization(response, chain, servletRequest);

    }

    /**
     * 检查token的合法性和权限
     *
     * @param response 返回
     * @param request  请求
     * @param chain    跳转
     * @author 刘飞华
     * @date: 2023/9/21 10:22
     */
    private void checkAuthorization(ServletResponse response, FilterChain chain, HttpServletRequest request)
            throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try {
            String token = request.getHeader("Authorization");
            String requestURI = request.getRequestURI();
            if (!StringUtils.hasText(token) || !token.startsWith("Bearer ")) {
                setResult(httpServletResponse, "Authorization参数缺失或者格式不正确");
                return;
            }
            token = token.substring(7);
            Claims claims = Jwts.parser().setSigningKey(TplConstant.JWT_SECRET_KEY).parseClaimsJws(token).getBody();
            String userName = (String) claims.get("userName");
            Integer userId = (Integer) claims.get("userId");
            Integer deptId = (Integer) claims.get("deptId");
            String deptName = (String) claims.get("deptName");
            List<String> permissions = (List<String>) claims.get("permissions");

            if (permissions.stream().noneMatch(x -> x.replace("/api","").equals(requestURI))) {
                setResult(httpServletResponse, "没有权限访问路径: " + requestURI);
                return;
            }

            HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(request);
            headerMapRequestWrapper.addHeader("userId", userId);
            headerMapRequestWrapper.addHeader("userName", userName);
            headerMapRequestWrapper.addHeader("deptId", deptId);
            headerMapRequestWrapper.addHeader("deptName", deptName);
            chain.doFilter(headerMapRequestWrapper, response);
        } catch (Exception e) {
            setResult(httpServletResponse, "解析token异常");
        }
    }

    /**
     * 设置返回
     *
     * @param response resp
     * @return
     * @author 刘飞华
     * @date: 2023/9/21 10:18
     */
    private void setResult(HttpServletResponse response, String message) throws IOException {
        log.error("authorization is error:{}", message);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(Result.resp(401, message)));
    }

    @Override
    public void destroy() {
        // 销毁方法
    }
}

