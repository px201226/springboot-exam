package com.example.springexam.exception.unchecked;


import com.example.springexam.exception.ExceptionMessage;

public class ClientBadRequestRuntimeException extends RuntimeException{

    public ClientBadRequestRuntimeException(ExceptionMessage naverApiUnauthorized){
        super();
    }
    public ClientBadRequestRuntimeException(String message){
        super(message);
    }

}
