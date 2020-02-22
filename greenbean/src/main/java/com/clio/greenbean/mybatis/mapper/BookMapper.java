package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.Author;
import com.clio.greenbean.domain.Book;
import com.clio.greenbean.domain.Translator;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2020/1/2
 */
public interface BookMapper {
    List<Map<String,Integer>> getSearchBooks(@Param("keyword") String keyword);
    
    Integer getSearchBooksCount(@Param("keyword") String keyword);
    
    List<Map<String, Integer>> getSearchBooksWithPagination(@Param("keyword")String keyword, @Param("start")Integer start, @Param("size")Integer size);
    
    Book getBooksBaseInfoByID(Integer id);
    
    List<Author> getAuthorByID(@Param("id") Integer id);
    
    List<Translator> getTranslatorByID(Integer id);
    
    Map<String, Object> getRatingAndRatingCountByID(Integer id);
    
    void insertBookBasicInfo(Book book);
    
    void insertBookAuthor(@Param("bookId")Integer bookId, @Param("author")List<Integer> author);
    
    void insertBookTranslator(@Param("bookId")Integer bookId, @Param("translator")List<Integer> translator);
    
    List<String> getAuthorSuggestion(String authorSuggestion);
    
    List<String> getTranslatorSuggestion(String translatorSuggestion);
}
