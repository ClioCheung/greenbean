package com.clio.greenbean.dto;

import com.clio.greenbean.vo.*;

/**
 * created by 吾乃逆世之神也 on 2020/3/15
 */
public class BookPageDTO {
    private BookBriefBasicInfo bookBriefBasicInfo = new BookBriefBasicInfo();
    private BookBriefStarRating bookBriefStarRating = new BookBriefStarRating();
    private BookDetailBasicInfo bookDetailBasicInfo = new BookDetailBasicInfo();
    private BookDetailStarRating bookDetailStarRating = new BookDetailStarRating();
    private BookUserRatingInfo bookUserRatingInfo = new BookUserRatingInfo();
    
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
    
    public BookDetailBasicInfo getBookDetailBasicInfo() {
        return bookDetailBasicInfo;
    }
    
    public void setBookDetailBasicInfo(BookDetailBasicInfo bookDetailBasicInfo) {
        this.bookDetailBasicInfo = bookDetailBasicInfo;
    }
    
    public BookDetailStarRating getBookDetailStarRating() {
        return bookDetailStarRating;
    }
    
    public void setBookDetailStarRating(BookDetailStarRating bookDetailStarRating) {
        this.bookDetailStarRating = bookDetailStarRating;
    }
    
    public BookUserRatingInfo getBookUserRatingInfo() {
        return bookUserRatingInfo;
    }
    
    public void setBookUserRatingInfo(BookUserRatingInfo bookUserRatingInfo) {
        this.bookUserRatingInfo = bookUserRatingInfo;
    }
}
