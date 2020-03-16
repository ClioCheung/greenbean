package com.clio.greenbean.vo;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2020/3/15
 */
public class BookDetailBasicInfo {
    private String subtitle;
    private String page;
    private String originalName;
    private String binding;
    private String isbn;
    private List<String> contentIntroList;
    private List<String> authorIntroList;
    private List<String> directoryList;
    
    public String getSubtitle() {
        return subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    
    public String getPage() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
    
    public String getOriginalName() {
        return originalName;
    }
    
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
    
    public String getBinding() {
        return binding;
    }
    
    public void setBinding(String binding) {
        this.binding = binding;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public List<String> getContentIntroList() {
        return contentIntroList;
    }
    
    public void setContentIntroList(List<String> contentIntroList) {
        this.contentIntroList = contentIntroList;
    }
    
    public List<String> getAuthorIntroList() {
        return authorIntroList;
    }
    
    public void setAuthorIntroList(List<String> authorIntroList) {
        this.authorIntroList = authorIntroList;
    }
    
    public List<String> getDirectoryList() {
        return directoryList;
    }
    
    public void setDirectoryList(List<String> directoryList) {
        this.directoryList = directoryList;
    }
}
