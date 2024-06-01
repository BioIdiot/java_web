package com.junyi.java_web.controller;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private int code;
    private String mes;

    public Result() {
    }

    public Result(Object data, int code, String mes) {
        this.data = data;
        this.code = code;
        this.mes = mes;
    }

    public Result(int code , Object data) {
        this.data = data;
        this.code = code;
    }
}
