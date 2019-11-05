package com.clio.greenbean.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 */
@Documented
@Constraint(validatedBy = {UserDTOUsernameValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDTOUsernameNotExistConstrain {
    @SuppressWarnings("unused")
    String message() default "This username exists.";
    
    Class<?>[] groups() default {};
    
    @SuppressWarnings("unused")
    Class<? extends Payload>[] payload() default {};
}
