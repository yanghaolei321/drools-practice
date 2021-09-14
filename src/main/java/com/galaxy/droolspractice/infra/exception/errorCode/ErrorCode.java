package com.galaxy.droolspractice.infra.exception.errorCode;

import lombok.Getter;

/**
 * 公共异常处理
 *
 * @author yanghaolei
 * @date 2021/09/14 上午11:32
 */
@Getter
public enum ErrorCode {

    UNKNOWN(1, "未知类型错误"),
    PARAM_ERROR(2, "参数错误"),
    DATA_NOT_FOUND(3, "资源不存在"),
    DATE_FORMAT_ERROR(4, "日期格式错误"),
    DATE_GREATER_NOW(5, "查询日期不能大于当前日期"),
    CREATE_EXCEL_ERROR(6, "生成EXCEL异常"),
    NETWORK_ERROR(7, "网络异常，请稍后重试"),


    ;

    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
