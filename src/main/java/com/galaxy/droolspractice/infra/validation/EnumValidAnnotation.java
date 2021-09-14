package com.galaxy.droolspractice.infra.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 验证枚举类值是否合法
 *
 * @author wangzukun
 * @date 2019/7/30 下午3:44
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidtor.class})
@Documented
public @interface EnumValidAnnotation {

    /**
     * 提示信息
     *
     * @return
     */
    String message() default "";

    /**
     * 是否允许空值
     *
     * @return
     */
    boolean allowNull() default true;

    /**
     * 分组
     *
     * @return
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 目标类（枚举）
     *
     * @return
     */
    Class<?>[] target() default {};

}
