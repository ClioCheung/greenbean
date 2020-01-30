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
}
