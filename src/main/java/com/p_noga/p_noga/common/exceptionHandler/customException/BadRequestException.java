package com.p_noga.p_noga.common.exceptionHandler.customException;

import com.p_noga.p_noga.common.exceptionHandler.CustomResponse;
import lombok.Getter;

//모든 잘 못된 요청에 대한 익셉션
@Getter
public class BadRequestException extends IllegalArgumentException {
    private final CustomResponse errorMessage;

    public BadRequestException(CustomResponse errorMessage){
        this.errorMessage = errorMessage;
    }
}
