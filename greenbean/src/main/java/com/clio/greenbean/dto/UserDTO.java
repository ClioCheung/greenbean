package com.clio.greenbean.dto;

import com.clio.greenbean.spring.validation.UserDTOPasswordEqualsConstrain;

import javax.validation.constraints.NotBlank;

/**
 * created by 吾乃逆世之神也 on 2019/10/28
 */
@UserDTOPasswordEqualsConstrain
public class UserDTO {
    
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
