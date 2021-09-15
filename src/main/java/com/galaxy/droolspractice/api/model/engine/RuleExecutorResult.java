package com.galaxy.droolspractice.api.model.engine;

import lombok.Data;

/**
 * 规则引擎-规则执行结果 Bean
 *
 * @author yanghaolei
 * @date 2021/09/14 下午5:03
 */

@Data
public class RuleExecutorResult {

    /**
     * 匹配综述
     */
    private int count;

    /**
     * 执行成功
     */
    private int success;

    /**
     * 执行失败
     */
    private int failure;


    public void addCount() {
        this.count += 1;
    }

    public void addFailure() {
        this.failure += 1;
    }

    public void addSuccess() {
        this.success += 1;
    }
}
