package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.Book;
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
            this.translateBookIntoDTO(book, searchBookItemsDTO);
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
    
    private SearchBookItemsDTO translateBookIntoDTO(Book book, SearchBookItemsDTO dto){
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
        System.out.println(publishDate);
        dto.setPublishDate(publishDate.toString());
        dto.setPrice(String.valueOf(book.getPrice()));
        return dto;
    }
}
