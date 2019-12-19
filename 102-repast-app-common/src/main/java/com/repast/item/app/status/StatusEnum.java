package com.repast.item.app.status;

/**
 * @author Dell
 */
public enum StatusEnum {

    SUCCESS("1","操作成功"),
    FAILED("2","操作失败"),
    EXIST("3","数据储存在"),
    NOT_EXIST("4","数据不存在"),
    DICTIONARY_NORMAL("5","数据字典正常"),
    DICTIONARY_DELETE("6","数据字典被删除"),
    UPDATE_OPERATION("7","修改操作"),
    DELETE_OPERATION("8","删除操作"),
    INSERT_OPERATION("9","新增操作");

    StatusEnum(String code,String msg){
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
