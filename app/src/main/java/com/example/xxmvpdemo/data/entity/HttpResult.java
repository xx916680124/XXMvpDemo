package com.example.xxmvpdemo.data.entity;

/**
 * author : xx
 * time : 2020/8/8 9:25
 * describe :
 **/
public class HttpResult<T> {
    private int code;

    private String message;

    private  T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
