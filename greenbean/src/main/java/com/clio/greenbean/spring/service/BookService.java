package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.Author;
import com.clio.greenbean.domain.Book;
import com.clio.greenbean.domain.Translator;
import com.clio.greenbean.dto.SearchBookItemsDTO;
import com.clio.greenbean.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2020/1/2
 */
@Service
public class BookService {
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    
    public List<SearchBookItemsDTO> getSearchBooks(String keyword){
        return this.getSearchBooks(keyword, null);
    }
    
    public List<SearchBookItemsDTO> getSearchBooks(String keyword, Integer start){
        List<Map<String, Integer>> searchBookItemsIDs;
        if(start != null){
            searchBookItemsIDs = this.getSearchBooksID(keyword,start);
        } else{
            searchBookItemsIDs = this.getSearchBooksID(keyword);
        }
        List<SearchBookItemsDTO> SearchBookDTOs = new ArrayList<>();
        for (Map<String, Integer> idMap : searchBookItemsIDs) {
            Integer id = idMap.get("id");
            // TODO 拿到book信息
            SearchBookItemsDTO dto = new SearchBookItemsDTO();
            Book book = this.getBooksBaseInfoByID(id);
            this.setBookIntoDTO(book, dto);
        
            List<Author> authorList = this.getAuthorByID(id);
            this.setAuthorByID(authorList,dto);
        
            List<Translator> translatorList = this.getTranslatorByID(id);
            this.setTranslatorByID(translatorList,dto);
        
            Map<String, Object>  ratings = this.getRatingAndRatingCountByID(id);
            this.setRatingByID(ratings,dto);
        
            SearchBookDTOs.add(dto);
        }
        return SearchBookDTOs;
    }
    
    public List<Map<String, Integer>> getSearchBooksID(String keyword){
        return bookMapper.getSearchBooks(keyword);
    }
    
    public List<Map<String, Integer>> getSearchBooksID(String keyword, Integer start){
        return bookMapper.getSearchBooksWithPagination(keyword,start);
    }
    
    public Book getBooksBaseInfoByID (Integer id) {
        return this.bookMapper.getBooksBaseInfoByID(id);
    }
    
    public List<Author> getAuthorByID(Integer id) {
        return this.bookMapper.getAuthorByID(id);
    }
    
    public List<Translator> getTranslatorByID(Integer id) {
        return this.bookMapper.getTranslatorByID(id);
    }
    
    public Map<String, Object> getRatingAndRatingCountByID(Integer id) {
        return this.bookMapper.getRatingAndRatingCountByID(id);
    }
    
    private SearchBookItemsDTO setBookIntoDTO(Book book, SearchBookItemsDTO dto){
        dto.setBookName(book.getName());
        dto.setPicture(book.getPicture());
        dto.setPublisher(book.getPublisher());
        StringBuilder publishDate = new StringBuilder();
        Integer year = book.getPublishYear();
        publishDate.append(year);
        Integer month = book.getPublishMonth();
        if(month != null) {
            publishDate.append("-");
            publishDate.append(month);
            Integer day = book.getPublishDay();
            if(day != null) {
                publishDate.append("-");
                publishDate.append(day);
            }
        }
        dto.setPublishDate(publishDate.toString());
        dto.setPrice(String.valueOf(book.getPrice()));
        return dto;
    }
    
    private void setAuthorByID(List<Author> authorList,SearchBookItemsDTO dto){
        StringBuilder authorsBuilder = new StringBuilder();
        for (Author author : authorList) {
            authorsBuilder.append(author.getName());
            authorsBuilder.append(" / ");
        }
        authorsBuilder.delete(authorsBuilder.length() - 3, authorsBuilder.length());
        dto.setAuthorName(authorsBuilder.toString());
    }
    
    private void setTranslatorByID(List<Translator> translatorList,SearchBookItemsDTO dto){
        StringBuilder translatorBuilder = new StringBuilder();
        for (Translator translator : translatorList) {
            translatorBuilder.append(translator.getName());
            translatorBuilder.append(" / ");
        }
        if(translatorBuilder.length() > 0) {
            translatorBuilder.delete(translatorBuilder.length() - 3, translatorBuilder.length());
            dto.setTranslatorName(translatorBuilder.toString());
        }
    }
    
    private void setRatingByID(Map<String, Object>  ratings, SearchBookItemsDTO dto) {
        Long ratingCount = (Long)ratings.get("ratingCount");
        dto.setRatingCount(String.valueOf(ratingCount));
        if(ratingCount > 0){
            BigDecimal rating = (BigDecimal) ratings.get("rating");
            BigDecimal ratingWithOneDecimal = rating.setScale(1, RoundingMode.HALF_UP);
            dto.setRating(ratingWithOneDecimal.intValue());

            DecimalFormat ratingFormat = new DecimalFormat("00");
            BigDecimal ratingWithTwoNum = rating.divide(new BigDecimal(2)).multiply(new BigDecimal(10));
            String starSuffix = ratingFormat.format(ratingWithTwoNum);
            String starRatingName = "star" + starSuffix;
            dto.setStarRatingName(starRatingName);
        } else {
            // XXX 修改硬代码
            dto.setStarRatingName("star00");
        }
    }
}
