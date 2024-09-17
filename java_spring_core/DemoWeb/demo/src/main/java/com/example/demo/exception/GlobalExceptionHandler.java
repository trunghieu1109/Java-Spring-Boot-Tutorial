package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, ResourceAccessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(Exception e, WebRequest request) {

        log.info("Validation Exception handled");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(new Date())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .status(HttpStatus.BAD_REQUEST.value(   ))
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        String msg = e.getMessage();
        int start = msg.lastIndexOf("[");
        int end = msg.lastIndexOf("]");

        String returned_msg = msg.substring(start + 1, end - 1);
        errorResponse.setMessage(returned_msg);

        return errorResponse;
    }

}
