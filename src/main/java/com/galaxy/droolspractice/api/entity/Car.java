package com.galaxy.droolspractice.api.entity;

/**
 * 类的描述
 *
 * @author yanghaolei
 * @date 2021/12/2 8:40 下午
 */

@org.kie.api.definition.type.ClassReactive
public class Car implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    private java.lang.Boolean isRight;

    private java.lang.String carNumber;

    public Car() {
    }

    public java.lang.Boolean getIsRight() {
        return this.isRight;
    }

    public void setIsRight(java.lang.Boolean isRight) {
        this.isRight = isRight;
    }

    public java.lang.String getCarNumber() {
        return this.carNumber;
    }

    public void setCarNumber(java.lang.String carNumber) {
        this.carNumber = carNumber;
    }

    public Car(java.lang.Boolean isRight, java.lang.String carNumber) {
        this.isRight = isRight;
        this.carNumber = carNumber;
    }

}