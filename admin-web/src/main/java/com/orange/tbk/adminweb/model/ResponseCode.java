package com.orange.tbk.adminweb.model;

/**
 * 基础的返回0-100
 * 成功类1xx
 * 失败类9xx
 * @author Orange
 */
public enum ResponseCode {

    //成功...
    LOGIN_SUCCESS(100,"登陆成功"),
    LOGOUT_SUCCESS(106,"登出成功"),

    //失败
    EMPTY(903,"无"),
    TOO_FAST(911,"访问过快"),
    LOGIN_ERROR(926,"登陆失败"),
    INTERFACE_CLOSE(938,"访问失败，接口已被关闭！"),
    VERIFICATION_FAILED(940, "验证失败，没有足够的权限进行访问"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(945, "请求错误，未找到指定资源"),
    SUBMISSION_AGREEMENT_ERROR(960, "提交协议不合法"),
    CONTENT_IS_TOO_LARGE(970, "提交内容过大"),
    UNKNOWN(980, "发生了一个未知错误"),

    //基础
    QUERY_SUCCESS(9,"查询成功"),
    SUCCESS(10,"操作成功"),
    ERROR(11,"操作失败"),
    QUERY_ERROR(13,"查询失败"),
    UNKNOWN_ERROR(14,"不好意思，发生了未知错误！"),
    PARAMETER_ERROR(15,"提交参数错误，请仔细检查提交参数！"),
    ;

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
