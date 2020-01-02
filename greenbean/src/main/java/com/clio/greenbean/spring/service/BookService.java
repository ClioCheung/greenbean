package com.clio.greenbean.spring.service;

import com.clio.greenbean.mybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   
    public List<Map<String, Object>> getSearchBooks(String keyword){
        List<Map<String, Object>> searchBookResult = bookMapper.getSearchBooks(keyword);
        return null;
    }
}
