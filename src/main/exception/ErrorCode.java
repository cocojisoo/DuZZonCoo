package com.example.DuZZonCoo.exception;

public enum ErrorCode{
    POST_NOT_FOUND("해당 게시글이 존재하지 않긔"),
    PASSWORD_MISMATCH("비밀번호가 틀렷긔"),
    DELETED_POST("지워진 게시글 이긔"),
    TITLE_OR_CONTENT_MISSING("제목 또는 내용이 누락되었긔"),
    TOO_LONG_TITLE("제목은 30자 이내로 써주시긔"),
    TOO_LONG_PASSWORD("비밀번호는 4자이상, 10자 이내로 만들어주시긔"),
    TOO_SHORT_PASSWORD("비밀번호는 4자이상, 10자 이내로 만들어주시긔"),
    INVALID_PASSWORD("비밀번호엔 영문자와 숫자로만 써주시긔"),
    WRONG_UUID_REQUEST("잘못된 접근이긔"),
    WRONG_HTTP_METHOD("잘못된 접근이긔"),
    DATABASE_BOOM("DB가 터졌긔");

    private final String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String message(){
        return message;
    }



}