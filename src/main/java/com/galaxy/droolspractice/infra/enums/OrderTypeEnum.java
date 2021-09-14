package com.galaxy.droolspractice.infra.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 排序类型枚举类
 * @author wangzukun
 * @date 2019/7/30 下午3:28
 */
@Getter
@AllArgsConstructor
public enum OrderTypeEnum implements IEnum<Integer> {

    ASC(1, "asc"),
    DESC(2, "desc"),
    ;

    private Integer value;
    private String desc;

}