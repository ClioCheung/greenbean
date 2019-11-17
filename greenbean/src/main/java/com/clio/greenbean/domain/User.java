package com.clio.greenbean.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public class User implements Serializable {
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isEnabled() == user.isEnabled() &&
               Objects.equals(getId(), user.getId()) &&
               Objects.equals(getUsername(), user.getUsername()) &&
               Objects.equals(getPassword(), user.getPassword()) &&
               Objects.equals(getAuthority(), user.getAuthority());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), isEnabled(), getAuthority());
    }
}
