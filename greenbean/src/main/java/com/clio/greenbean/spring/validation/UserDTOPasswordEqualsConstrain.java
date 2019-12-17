package com.clio.greenbean.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 *
 * 验证用户密码与密码确认是否相等
 *
 * @see UserDTOPasswordValidator
 *
 */
@Documented
@Constraint(validatedBy = {UserDTOPasswordValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDTOPasswordEqualsConstrain {
    
    @SuppressWarnings("unused")
    String message() default "This password does not equal to confirmPassword";
    
    Class<?>[] groups() default {};
    
    @SuppressWarnings("unused")
    Class<? extends Payload>[] payload() default {};
}
