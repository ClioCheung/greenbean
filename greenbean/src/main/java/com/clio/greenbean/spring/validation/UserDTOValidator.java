package com.clio.greenbean.spring.validation;

import com.clio.greenbean.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 */
public class UserDTOValidator implements ConstraintValidator<UserDTOPasswordEqualsConstrain, UserDTO> {
    @Override
    public void initialize(UserDTOPasswordEqualsConstrain constraintAnnotation) {
    }
    
    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        String password = userDTO.getPassword();
        String confirmPassword = userDTO.getConfirmPassword();
        boolean validateResult = password.equals(confirmPassword);
        return validateResult;
    }
}
