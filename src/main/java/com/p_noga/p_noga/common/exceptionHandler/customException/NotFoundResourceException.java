package com.p_noga.p_noga.common.exceptionHandler.customException;

import com.p_noga.p_noga.common.exceptionHandler.CustomResponse;
import lombok.Getter;

//조회되는 결과가 없을 때
@Getter
public class NotFoundResourceException extends IllegalArgumentException {

    private final CustomResponse errorMessage;

    public NotFoundResourceException(CustomResponse errorMessage) { this.errorMessage = errorMessage; }
}
