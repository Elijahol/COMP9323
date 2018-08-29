package com.vport.system.bean;

import java.util.List;

public class ResponseData {
    
    private Integer code;
    private String msg;
    private List<?> data;
    
    public ResponseData() {}
    public ResponseData(Integer code, String msg, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public List<?> getData() {
        return data;
    }
    public void setData(List<?> data) {
        this.data = data;
    }
    
    
}
