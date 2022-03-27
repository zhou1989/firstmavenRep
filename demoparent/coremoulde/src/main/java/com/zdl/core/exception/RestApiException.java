package com.zdl.core.exception;


public class RestApiException extends Exception {
    String massage;
    Exception e;

    public RestApiException(String message,  Exception e) {
        super(message, e);
        this.massage = massage;
        this.e = e;
    }

    public RestApiException() {
        this.massage = massage;
        this.e = e;
    }

}
