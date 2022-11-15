package com.sander.worklogger.common.exception;

import com.sander.worklogger.common.response.Result;
import com.sander.worklogger.common.response.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception){
        log.error(exception.toString());
        return new Result(StatusEnum.ERROR, exception.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public Result handleBizException(BizException bizException){
        log.info(bizException.toString());
        if (bizException.isMessageExist()){
            return new Result(bizException.getStatusEnum(), bizException.getMessage());
        }
        return new Result(bizException.getStatusEnum());
    }

}
