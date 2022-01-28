package com.galaxy.droolspractice.api.entity;

/**
 * 类的描述
 *
 * @author yanghaolei
 * @date 2021/12/2 7:40 下午
 */

@org.kie.api.definition.type.ClassReactive
public class FeatureDataObject implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @org.kie.api.definition.type.Label("过去一年的消耗总额")
    private java.lang.Integer consumeOneYear;
    @org.kie.api.definition.type.Label(" 过去一年的有效订单数")
    private java.lang.Integer invalidOrderNumsForOneYear;

    @org.kie.api.definition.type.Label("是否需要处理")
    @org.kie.api.definition.type.Description("1 = 要处理 0 = 不处理")
    private Integer processFlag;

    @org.kie.api.definition.type.Label("数据特征对象对应的本体id")
    private int id;

    public FeatureDataObject() {
    }

    public java.lang.Integer getConsumeOneYear() {
        return this.consumeOneYear;
    }

    public void setConsumeOneYear(java.lang.Integer consumeOneYear) {
        this.consumeOneYear = consumeOneYear;
    }

    public java.lang.Integer getInvalidOrderNumsForOneYear() {
        return this.invalidOrderNumsForOneYear;
    }

    public void setInvalidOrderNumsForOneYear(
        java.lang.Integer invalidOrderNumsForOneYear) {
        this.invalidOrderNumsForOneYear = invalidOrderNumsForOneYear;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.Integer getProcessFlag() {
        return this.processFlag;
    }

    public void setProcessFlag(java.lang.Integer processFlag) {
        this.processFlag = processFlag;
    }

    public FeatureDataObject(java.lang.Integer consumeOneYear,
                             java.lang.Integer invalidOrderNumsForOneYear,
                             java.lang.Integer processFlag, int id) {
        this.consumeOneYear = consumeOneYear;
        this.invalidOrderNumsForOneYear = invalidOrderNumsForOneYear;
        this.processFlag = processFlag;
        this.id = id;
    }

}
