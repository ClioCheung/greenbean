package com.clio.greenbean.vo;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2020/3/15
 */
public class BookDetailStarRating {
    private List<String> ratingPercentageList;
    private List<String> ratingPowerPercentageList;
    
    public List<String> getRatingPercentageList() {
        return ratingPercentageList;
    }
    
    public void setRatingPercentageList(List<String> ratingPercentageList) {
        this.ratingPercentageList = ratingPercentageList;
    }
    
    public List<String> getRatingPowerPercentageList() {
        return ratingPowerPercentageList;
    }
    
    public void setRatingPowerPercentageList(List<String> ratingPowerPercentageList) {
        this.ratingPowerPercentageList = ratingPowerPercentageList;
    }
}
