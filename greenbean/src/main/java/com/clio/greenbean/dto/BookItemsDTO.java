package com.clio.greenbean.dto;

import com.clio.greenbean.vo.BookBriefBasicInfo;
import com.clio.greenbean.vo.BookBriefStarRating;

/**
 * created by 吾乃逆世之神也 on 2020/1/2
 */
public class BookItemsDTO {
    private BookBriefBasicInfo bookBriefBasicInfo = new BookBriefBasicInfo();
    private BookBriefStarRating bookBriefStarRating = new BookBriefStarRating();
    
    public BookBriefBasicInfo getBookBriefBasicInfo() {
        return bookBriefBasicInfo;
    }
    
    public void setBookBriefBasicInfo(BookBriefBasicInfo bookBriefBasicInfo) {
        this.bookBriefBasicInfo = bookBriefBasicInfo;
    }
    
    public BookBriefStarRating getBookBriefStarRating() {
        return bookBriefStarRating;
    }
    
    public void setBookBriefStarRating(BookBriefStarRating bookBriefStarRating) {
        this.bookBriefStarRating = bookBriefStarRating;
    }
}
