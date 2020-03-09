package com.orange.tbk.adminweb.config;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.redis.RedisKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
@Slf4j
@Component
public class ApiAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            ApiAuth apiAuth =  method.getMethodAnnotation(ApiAuth.class);

            // 没有注解，直接放行
            if (null == apiAuth) return true;

            // 接口关闭了
            if (apiAuth.close()) {
                toJson(response, Response.build(ResponseCode.INTERFACE_CLOSE));
                return false;
            }

            // 管理端接口验证拦截
            if (apiAuth.type().equals(ApiAuthConstant.ADMIN)) {
                return adminIntercept(request, response);
            }

            toJson(response, Response.build(ResponseCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED));
            return false;
        }
        return true;
    }

    /**
     * 管理端拦截
     */
    private boolean adminIntercept(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (!StrUtil.isBlank(token)) {
                    continue;
                }
                if (ApiAuthConstant.TOKEN_NAME.equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        } else {
            toJson(response, Response.build(ResponseCode.VERIFICATION_FAILED));
            return false;
        }

        if (!StrUtil.isBlank(token)) {
            Boolean hasKey = redisTemplate.hasKey(RedisKeyConstant.TOKEN + token);
            if (hasKey == null || hasKey == false) {
                toJson(response, Response.build(ResponseCode.LOGIN_ERROR));
                return false;
            }
        } else {
            toJson(response, Response.build(ResponseCode.VERIFICATION_FAILED));
            return false;
        }
        return true;
    }

    /**
     * 输出json
     */
    private void toJson(HttpServletResponse response, Response res) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.append(JSONObject.toJSONString(res));
        } catch (IOException e) {
            log.error("登录拦截输出json错误: {}", ExceptionUtil.stacktraceToString(e));
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

}

