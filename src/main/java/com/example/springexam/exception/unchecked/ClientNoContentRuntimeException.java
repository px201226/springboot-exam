package com.example.springexam.exception.unchecked;


import com.example.springexam.exception.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ClientNoContentRuntimeException extends RuntimeException{

    public ClientNoContentRuntimeException(){
        super(ExceptionMessage.NO_CONTENT.getMessage());
    }

}
