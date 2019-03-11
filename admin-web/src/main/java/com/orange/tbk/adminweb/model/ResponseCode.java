package com.orange.tbk.adminweb.model;

/**
 * 基础的返回0-100
 * 成功类1xx 单位为百
 * 失败类9xx 单位为百
 * @author Orange
 */
public enum ResponseCode {

    //成功...
    LOGIN_SUCCESS(100,"登陆成功"),

    LOGOUT_SUCCESS(106,"登出成功"),


    //失败
    EMPTY(903,"无"),

    TOO_FAST(911,"访问过快"),

    LOGOUT_ERROR(925,"登出失败"),

    LOGIN_ERROR(926,"登陆失败"),

    INTERFACE_CLOSE(938,"访问失败，接口已被关闭！"),

    //基础
    QUERY_SUCCESS(9,"查询成功"),
    SUCCESS(10,"操作成功"),
    ERROR(11,"操作失败"),
    NOT_LOGIN(12,"未登录"),
    QUERY_ERROR(13,"查询失败"),
    UNKNOWN_ERROR(14,"不好意思，发生了未知错误！"),
    PARAMETER_ERROR(15,"提交参数错误，请仔细检查提交参数！"),
    EXIST(16,"存在"),
    NO_EXIST(17,"不存在"),
    NOT_ROLE(99,"无角色");

    private int code;
    private String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
