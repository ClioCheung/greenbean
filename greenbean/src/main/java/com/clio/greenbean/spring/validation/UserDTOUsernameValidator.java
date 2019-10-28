package com.clio.greenbean.spring.validation;

import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 */
public class UserDTOUsernameValidator implements ConstraintValidator<UserDTOUsernameNotExistConstrain, String> {
    
    @Autowired
    private UserService userService;
    
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.validateUsername(s);
    }
    
}
