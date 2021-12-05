package com.example.quotesrestapi.model;

public class ResponseTransfer <T>{
    public String status;
    public T data;
    public String msg;

    public ResponseTransfer(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseTransfer(String status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseTransfer{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
