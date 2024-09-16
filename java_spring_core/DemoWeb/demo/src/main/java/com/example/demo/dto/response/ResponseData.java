package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseData<T> {

    private final int status;
    private final String message;
    private T data;

    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public T getData() {
        return data;
    }
}
