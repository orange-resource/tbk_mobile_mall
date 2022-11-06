package com.orange.tbk.api.redis;

/**
 * reis key 常量池
 * @author Orange软件
 * @date 2019.3.12
 */
public class RedisKeyConstant {

    private static final String APPLICATION_NAME = "tbk-application:";

    /**
     * token 存储前缀
     */
    public static final String TOKEN = APPLICATION_NAME + "token:";

    /**
     * admin web 开放接口管理key
     */
    public final static String OPEN_INTERFACE = APPLICATION_NAME + "open-interface:";

    /**
     * admin web 访问人IP录入key
     */
    public final static String IP_LIBRARY = APPLICATION_NAME + "ip-library:";

    /**
     * API数据 KEY 前缀key
     */
    public final static String API_DATA = APPLICATION_NAME + "api-data:";

    /**
     * oss
     */
    public final static String ALIYUNOSS_IMPL = APPLICATION_NAME + "oss:";

    /**
     * admin system config impl key
     */
    public final static String SYSTEMCONFIG_IMPL = APPLICATION_NAME + "SystemConfigImpl:";

    /**
     * admin carousel impl key
     */
    public final static String CAROUSEL_IMPL = APPLICATION_NAME + "CarouselImpl:";

}
