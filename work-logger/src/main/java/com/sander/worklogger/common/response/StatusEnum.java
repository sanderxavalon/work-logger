package com.sander.worklogger.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    SUCCESS(100,"SUCCESS"),
    FAIL(001,"FAIL"),
    NOT_LOGIN(101,"NOT LOGIN"),
    NO_USER_FOUND(501,"NO USER FOUND"),
    INCORRECT_PASSWORD(502, "INCORRECT PASSWORD"),
    ERROR(999,"ERROR");
    int status;
    String message;
}
