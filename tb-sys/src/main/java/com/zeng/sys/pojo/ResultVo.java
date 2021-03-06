package com.zeng.sys.pojo;

public class ResultVo {

    private String code;
    private String message;
    private Object data;

    public ResultVo(){}

    public ResultVo(String code, String message){
        this.code = code;
        this.message = message;
    }

    public ResultVo(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setDate(Object data) {
        this.data = data;
    }
}
