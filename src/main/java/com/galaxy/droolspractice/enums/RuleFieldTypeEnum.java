package com.galaxy.droolspractice.enums;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Map;

@Getter
public enum RuleFieldTypeEnum {

    /**
     * 规则的变量类型
     */
    STRING(1, "String", "STRING-字符串"),
    LONG(3, "Long", "LONG-长整型"),
    DOUBLE(4, "Double", "DOUBLE-浮点型"),

    ;

    private int code;
    private String value;
    private String desc;

    private static final Map<Integer, RuleFieldTypeEnum> valuesMap = Maps.newHashMapWithExpectedSize(16);

    RuleFieldTypeEnum(int code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    static {
        for (RuleFieldTypeEnum ruleFieldTypeEnum : RuleFieldTypeEnum.values()) {
            valuesMap.put(ruleFieldTypeEnum.code, ruleFieldTypeEnum);
        }
    }

    public static RuleFieldTypeEnum getByValue(Integer code) {
        return valuesMap.keySet().contains(code) ? valuesMap.get(code) : null;

    }

}
