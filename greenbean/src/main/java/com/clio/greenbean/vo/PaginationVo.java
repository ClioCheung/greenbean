package com.clio.greenbean.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * created by 吾乃逆世之神也 on 2020/1/14
 */
public class PaginationVo {
    private int singleSize;
    private int offset;
    private int totalItemsCount;
    
    public PaginationVo(int singleSize, int offset, int totalItemsCount) {
        this.singleSize = singleSize;
        this.offset = offset;
        this.totalItemsCount = totalItemsCount;
    }
    
    public int getSingleSize() {
        return singleSize;
    }
    
    public void setSingleSize(int singleSize) {
        this.singleSize = singleSize;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public int getTotalItemsCount() {
        return totalItemsCount;
    }
    
    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }
    
    public int getPageNumber(){
        int number = 0;
        if(singleSize != 0) {
            number = offset / singleSize + 1;
        }
        return number;
    }
    
    public int getTotalPagesCount(){
        int count = 0;
        if(singleSize != 0){
            BigDecimal totalItemsCountBigDecimal = new BigDecimal(totalItemsCount);
            BigDecimal singleSizeBigDecimal = new BigDecimal(singleSize);
            BigDecimal bigDecimal =totalItemsCountBigDecimal.divide(singleSizeBigDecimal);
            bigDecimal = bigDecimal.setScale(0, RoundingMode.UP);
            count = bigDecimal.intValue();
        }
        return count;
    }

}
