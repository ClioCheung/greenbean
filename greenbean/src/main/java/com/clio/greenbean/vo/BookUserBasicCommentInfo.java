package com.clio.greenbean.vo;

/**
 * created by 吾乃逆世之神也 on 2020/3/26
 */
public class BookUserBasicCommentInfo {
    private String nickname;
    private String starSuffix;
    private String CommentTime;
    private String comment;
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getStarSuffix() {
        return starSuffix;
    }
    
    public void setStarSuffix(String starSuffix) {
        this.starSuffix = starSuffix;
    }
    
    public String getCommentTime() {
        return CommentTime;
    }
    
    public void setCommentTime(String commentTime) {
        CommentTime = commentTime;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
}
