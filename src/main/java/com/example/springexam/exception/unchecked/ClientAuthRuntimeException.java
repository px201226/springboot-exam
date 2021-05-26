package com.example.springexam.exception.unchecked;


import com.example.springexam.exception.ExceptionMessage;

public class ClientAuthRuntimeException extends RuntimeException{

    public ClientAuthRuntimeException(){
        super();
    }
    public ClientAuthRuntimeException(String message){
        super(message);
    }

    public ClientAuthRuntimeException(ExceptionMessage em) {
        super(em.getMessage());
    }
}
