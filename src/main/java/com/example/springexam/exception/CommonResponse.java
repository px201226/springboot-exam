package com.example.springexam.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponse {

    private String message;
    private int status;

}
