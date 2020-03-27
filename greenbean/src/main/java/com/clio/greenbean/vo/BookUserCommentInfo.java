package com.clio.greenbean.vo;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2020/3/26
 */
public class BookUserCommentInfo {
    private List<BookUserBasicCommentInfo> bookUserBasicCommentInfoList;
    private Integer commentCount;
    
    public List<BookUserBasicCommentInfo> getBookUserBasicCommentInfoList() {
        return bookUserBasicCommentInfoList;
    }
    
    public void setBookUserBasicCommentInfoList(List<BookUserBasicCommentInfo> bookUserBasicCommentInfoList) {
        this.bookUserBasicCommentInfoList = bookUserBasicCommentInfoList;
    }
    
    public Integer getCommentCount() {
        return commentCount;
    }
    
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
