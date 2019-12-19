package com.repast.item.app.status;



public enum  LoginStatus {

    LOGIN_SUCCESS("200","登陆成功"),
    LOGIN_FAILED("400","登陆失败"),
    USER_EXIST("201","用户存在"),
    USER_NOT_EXIST("402","用户不存在"),
    PASSWORD_WRONG("405","密码错误"),
    LOGOUT_WRONG("403","用户退出异常"),
    USER_HAS_PERMISSION("202","用户拥有权限"),
    USER_HAS_NOT_PERMISSION("406","用户没有登陆权限");


    LoginStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
