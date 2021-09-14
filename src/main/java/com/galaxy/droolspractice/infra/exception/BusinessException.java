package com.galaxy.droolspractice.infra.exception;

import com.galaxy.droolspractice.infra.exception.errorCode.ErrorCode;

/**
 * 类的描述
 *
 * @author yanghaolei
 * @date 9/14/21 7:56 PM
 */

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -1L;

    protected String message;
    protected int errorCode;


    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode.getCode();
    }
}
