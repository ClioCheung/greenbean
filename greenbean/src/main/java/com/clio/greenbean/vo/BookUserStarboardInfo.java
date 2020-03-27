package com.clio.greenbean.vo;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2020/3/27
 */
public class BookUserStarboardInfo {
    private List<StarboardInfo> starboardInfoList;
    private Integer readCount;
    private Integer readingCount;
    
    public List<StarboardInfo> getStarboardInfoList() {
        return starboardInfoList;
    }
    
    public void setStarboardInfoList(List<StarboardInfo> starboardInfoList) {
        this.starboardInfoList = starboardInfoList;
    }
    
    public Integer getReadCount() {
        return readCount;
    }
    
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
    
    public Integer getReadingCount() {
        return readingCount;
    }
    
    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }
}