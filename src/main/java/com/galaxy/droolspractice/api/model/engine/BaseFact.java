package com.galaxy.droolspractice.api.model.engine;

import lombok.Data;

/**
 * 基类fact
 */
@Data
public class BaseFact {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    private Integer age;

}
