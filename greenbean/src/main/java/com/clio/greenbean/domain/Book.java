package com.clio.greenbean.domain;

/**
 * created by 吾乃逆世之神也 on 2020/1/3
 */
public class Book {
    private Integer id;
    private String name;
    private String isbn;
    private String picture;
    private String publisher;
    private Integer publishYear;
    private Integer publishMonth;
    private Integer publishDay;
    private float price;
    private String subtitle;
    private String originalName;
    private Integer binding;
    private Integer page;
    private String contentIntro;
    private String authorIntro;
    private String directory;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public Integer getPublishYear() {
        return publishYear;
    }
    
    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }
    
    public Integer getPublishMonth() {
        return publishMonth;
    }
    
    public void setPublishMonth(Integer publishMonth) {
        this.publishMonth = publishMonth;
    }
    
    public Integer getPublishDay() {
        return publishDay;
    }
    
    public void setPublishDay(Integer publishDay) {
        this.publishDay = publishDay;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getSubtitle() {
        return subtitle;
    }
    
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    
    public String getOriginalName() {
        return originalName;
    }
    
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
    
    public Integer getBinding() {
        return binding;
    }
    
    public void setBinding(Integer binding) {
        this.binding = binding;
    }
    
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public String getContentIntro() {
        return contentIntro;
    }
    
    public void setContentIntro(String contentIntro) {
        this.contentIntro = contentIntro;
    }
    
    public String getAuthorIntro() {
        return authorIntro;
    }
    
    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }
    
    public String getDirectory() {
        return directory;
    }
    
    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
