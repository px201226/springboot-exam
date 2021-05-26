package com.example.springexam.exception;


import com.example.springexam.exception.unchecked.ClientNoContentRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.springexam.web")
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNoContentRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResponse handleClientNoContentRuntimeException(Exception e){

        log.error("handleClientNoContentRuntimeException", e.getMessage());

        return new CommonResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
