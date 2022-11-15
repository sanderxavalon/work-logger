package com.sander.worklogger.common.exception;

import com.sander.worklogger.common.response.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class BizException extends RuntimeException{

    private StatusEnum statusEnum;

    public BizException(StatusEnum statusEnum){
        super();
        this.statusEnum = statusEnum;
    }

    public BizException(StatusEnum statusEnum, String message) {
        super(message);
        this.statusEnum = statusEnum;
    }

    public boolean isMessageExist() {
        return StringUtils.isEmpty(this.getMessage());
    }
}
