package com.clio.greenbean.vo;

/**
 * created by 吾乃逆世之神也 on 2020/3/27
 */
public class StarboardInfo {
    private String avatar;
    private String nickname;
    private String starboardDate;
    private String starSuffix;
    private Integer type;
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getStarboardDate() {
        return starboardDate;
    }
    
    public void setStarboardDate(String starboardDate) {
        this.starboardDate = starboardDate;
    }
    
    public String getStarSuffix() {
        return starSuffix;
    }
    
    public void setStarSuffix(String starSuffix) {
        this.starSuffix = starSuffix;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
}