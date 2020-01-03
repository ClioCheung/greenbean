package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2020/1/2
 */
public interface BookMapper {
    List<Map<String,Integer>> getSearchBooks(@Param("keyword") String keyword);
    Book getBooksBaseInfoByID(Integer id);
}
