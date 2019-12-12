package com.huaita.springcloudcommon.constant;

public class ResponseBase<T>{

    private Integer resCode;

    private String resMsg;

    private T Data;

    public ResponseBase(Integer resCode, String resMsg, T data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        Data = data;
    }

    public ResponseBase(){

    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "resCode=" + resCode +
                ", resMsg='" + resMsg + '\'' +
                ", Data=" + Data +
                '}';
    }
}
