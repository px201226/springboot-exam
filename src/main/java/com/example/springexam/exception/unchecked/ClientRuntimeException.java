package com.example.springexam.exception.unchecked;


public class ClientRuntimeException extends RuntimeException{

    public ClientRuntimeException(){
        super();
    }
    public ClientRuntimeException(String message){
        super(message);
    }

}
