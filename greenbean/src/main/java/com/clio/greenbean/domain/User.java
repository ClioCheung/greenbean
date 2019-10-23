package com.clio.greenbean.domain;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private boolean enabled;
    private List<String> authority;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    @SuppressWarnings("unused")
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @SuppressWarnings("unused")
    public List<String> getAuthority() {
        return authority;
    }
    
    public void setAuthority(List<String> authority) {
        this.authority = authority;
    }
}
