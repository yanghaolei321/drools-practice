package com.galaxy.droolspractice.api.model.engine;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

/**
 * 规则引擎-规则执行Global结果 Bean
 * 丢到规则去匹配的数据
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */

@Data
public class RuleExecuteGlobal {

    /**
     * Fact对象
     */
    private BaseFact factBean;

    /**
     * 执行结果
     */
    private RuleExecutorResult result;



}
