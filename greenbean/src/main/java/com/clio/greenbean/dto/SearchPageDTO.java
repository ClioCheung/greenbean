package com.clio.greenbean.dto;

import com.clio.greenbean.vo.PaginationVo;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2020/1/14
 */
public class SearchPageDTO {
    private List<SearchBookItemsDTO> bookItemsList;
    private PaginationVo paginationVo;
    
    public List<SearchBookItemsDTO> getBookItemsList() {
        return bookItemsList;
    }
    
    public void setBookItemsList(List<SearchBookItemsDTO> bookItemsList) {
        this.bookItemsList = bookItemsList;
    }
    
    public PaginationVo getPaginationVo() {
        return paginationVo;
    }
    
    public void setPaginationVo(PaginationVo paginationVo) {
        this.paginationVo = paginationVo;
    }
}
