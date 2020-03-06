package com.clio.greenbean.dto;

import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2020/1/2
 */
public class BookItemsDTO {
    private String id;
    private String bookName;
    private String starRatingName;
    private String rating;
    private String ratingCount;
    private String authorName;
    private String translatorName;
    private String publisher;
    private String publishDate;
    private String price;
    private String picture;
    private String subtitle;
    private String page;
    private String originalName;
    private String binding;
    private String isbn;
    private String contentIntro;
    private String authorIntro;
    private String directory;
    private Map<String, String> ratingPercentageList;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getBookName() {
        return bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public String getStarRatingName() {
        return starRatingName;
    }
    
    public void setStarRatingName(String starRatingName) {
        this.starRatingName = starRatingName;
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getRatingCount() {
        return ratingCount;
    }
    
    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }
    
    public String getAuthorName() {
        return authorName;
    }
    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    public String getTranslatorName() {
        return translatorName;
    }
    
    public void setTranslatorName(String translatorName) {
        this.translatorName = translatorName;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
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
    
    public Map<String, String> getRatingPercentageList() {
        return ratingPercentageList;
    }
    
    public void setRatingPercentageList(Map<String, String> ratingPercentageList) {
        this.ratingPercentageList = ratingPercentageList;
    }
}
