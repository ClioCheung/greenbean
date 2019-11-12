package com.clio.greenbean.spring.validation;

import com.clio.greenbean.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * created by 吾乃逆世之神也 on 2019/11/12
 */
class UserDTOPasswordValidatorTest {
    private UserDTOPasswordValidator userDTOPasswordValidator;
    
    @BeforeEach
    void setup(){
        userDTOPasswordValidator = new UserDTOPasswordValidator();
    }
    
    @Test
    void TestIsValidPasswordEquals() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("passwordEquals");
        userDTO.setConfirmPassword("passwordEquals");
        Assertions.assertTrue(userDTOPasswordValidator.isValid(userDTO,null));
    }
    
    @Test
    void TestIsValidPasswordNotEquals() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("passwordNotEquals");
        userDTO.setConfirmPassword("passwordEquals");
        Assertions.assertFalse(userDTOPasswordValidator.isValid(userDTO,null));
    }
    
}