package com.orange.tbk.adminweb.annotation;

import java.lang.annotation.*;

/**
 * 接口拦截注解
 * @author orange
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiAuth {

    /**
     * 是否关闭接口访问
     */
    boolean close() default false;

    String type();

}
