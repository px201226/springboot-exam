package com.example.springexam.exception;


import lombok.Getter;

@Getter
public enum  ExceptionMessage {

    NAVER_API_UNAUTHORIZED("네이버 오픈API 통신 중 인증 에러가 발생"),
    NAVER_API_BAD_REQUEST("잘못된 요청 입니다"),
    NAVER_API_ERROR("네이버 오픈 API 통신 에러입니다."),
    NO_CONTENT("데이터가 없습니다");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

}
