package com.orange.tbk.adminweb.config;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.orange.tbk.adminweb.model.ParameterError;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.InterfaceManagement;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.sc.InterfaceManagementIpHandle;
import com.orange.tbk.api.sc.InterfaceManagementVisit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * rsp简化aop
 * @author Orange
 * @date 2018/10/13
 */
@Aspect
@Component
public class RspHandleAspect {

    private static final Logger log = LoggerFactory.getLogger(RspHandleAspect.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.orange.tbk.adminweb.annotation.RspHandle)")
    public void annotationPointCut() {

    }

    @Around("annotationPointCut()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {

        RspHandle rspHandle = getRspHandle(pjp);

        boolean setErrorInfo = rspHandle.isSetErrorInfo();

        boolean returnObject = rspHandle.isReturnObject();

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String url =
                pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();

        InterfaceManagement interfaceManagement =
                (InterfaceManagement) redisTemplate.opsForValue().get(RedisKeyConstant.OPEN_INTERFACE + url);
        if (interfaceManagement != null) {

            if (interfaceManagement.getVisit() == InterfaceManagementVisit.CLOSE.getStatusCode()) {

                return Response.build(ResponseCode.INTERFACE_CLOSE);
            } else if (interfaceManagement.getIpHandle() == InterfaceManagementIpHandle.START.getStatusCode()) {

                String remoteAddr =
                        RedisKeyConstant.IP_LIBRARY + request.getRemoteAddr().replaceAll(":",".");

                long count = redisTemplate.opsForValue().increment(remoteAddr, 1);
                if (count == 1) {
                    redisTemplate.expire(remoteAddr, interfaceManagement.getIpRedisInterval(), TimeUnit.MINUTES);
                }
                if (count > interfaceManagement.getIpVisits()) {
                    Long expire = redisTemplate.getExpire(remoteAddr);
                    String msg = "访问过快哦！" + expire + "秒过后才能继续访问";
                    return Response.build(ResponseCode.TOO_FAST,msg);
                }
            }

        }

        try {

            if (returnObject == false) {
                long startTime = System.currentTimeMillis();

                Response response = (Response) pjp.proceed();

                long endTime = System.currentTimeMillis();

                response.setTotalTime(endTime - startTime);

                return response;
            } else {
                return pjp.proceed();
            }

        } catch (ParameterError e) {
            return Response.build(ResponseCode.PARAMETER_ERROR, e.getMessage());
        } catch (Throwable t) {
            String name = t.getClass().getName();
            log.error("\n项目异常：class: {} - {}", name, ExceptionUtil.stacktraceToString(t));
            if (setErrorInfo == true) {
                return Response.build(ResponseCode.UNKNOWN_ERROR, t.getMessage());
            } else {
                return Response.build(ResponseCode.UNKNOWN_ERROR);
            }
        }

    }

    private RspHandle getRspHandle(ProceedingJoinPoint pjp) {
        MethodSignature sign =  (MethodSignature) pjp.getSignature();
        Method method = sign.getMethod();
        return method.getAnnotation(RspHandle.class);
    }

}
