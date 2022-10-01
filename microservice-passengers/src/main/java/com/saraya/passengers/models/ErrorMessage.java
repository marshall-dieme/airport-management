package com.saraya.passengers.models;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private int code;
    private HttpStatus status;
    private String message;
    private String contextPath;

    public ErrorMessage(int code, HttpStatus status, String message, String contextPath) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.contextPath = contextPath;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
