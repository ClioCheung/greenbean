package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.Author;
import com.clio.greenbean.domain.Book;
import com.clio.greenbean.domain.Translator;
import com.clio.greenbean.dto.SearchBookItemsDTO;
import com.clio.greenbean.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<SearchBookItemsDTO> SearchBookDTOs = new ArrayList<>();
        List<Map<String, Integer>> searchBookItemsIDs = this.getSearchBooksID(keyword);
        
        for (Map<String, Integer> idMap : searchBookItemsIDs) {
            Integer id = idMap.get("id");
            // TODO 拿到book信息
            SearchBookItemsDTO searchBookItemsDTO = new SearchBookItemsDTO();
            Book book = this.getBooksBaseInfoByID(id);
            this.setBookIntoDTO(book, searchBookItemsDTO);
            
            List<Author> authorList = this.getAuthorByID(id);
            this.setAuthorByID(authorList,searchBookItemsDTO);
            
            List<Translator> translatorList = this.getTranslatorByID(id);
            this.setTranslatorByID(translatorList,searchBookItemsDTO);
            
            SearchBookDTOs.add(searchBookItemsDTO);
        }
        return SearchBookDTOs;
    }
   
    public List<Map<String, Integer>> getSearchBooksID(String keyword){
        return bookMapper.getSearchBooks(keyword);
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
    
    public void setAuthorByID(List<Author> authorList,SearchBookItemsDTO searchBookItemsDTO){
        StringBuilder authorsBuilder = new StringBuilder();
        for (Author author : authorList) {
            authorsBuilder.append(author.getName());
            authorsBuilder.append(" / ");
        }
        authorsBuilder.delete(authorsBuilder.length() - 3, authorsBuilder.length());
        searchBookItemsDTO.setAuthorName(authorsBuilder.toString());
    }
    
    public void setTranslatorByID(List<Translator> translatorList,SearchBookItemsDTO searchBookItemsDTO){
        StringBuilder translatorBuilder = new StringBuilder();
        for (Translator translator : translatorList) {
            translatorBuilder.append(translator.getName());
            translatorBuilder.append(" / ");
        }
        translatorBuilder.delete(translatorBuilder.length() - 3, translatorBuilder.length());
        searchBookItemsDTO.setTranslatorName(translatorBuilder.toString());
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
}
