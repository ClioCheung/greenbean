package com.clio.greenbean.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 */
@Documented
@Constraint(validatedBy = {UserDTOValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDTOPasswordEqualsConstrain {
    
    String message() default "你输入的密码不一致";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
