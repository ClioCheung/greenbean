package com.clio.greenbean.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/12/20
 */
@Mapper
public interface MyBookMapper {

    Integer getMyBookCount(@Param("type")Short type, @Param("userId")Integer userId);

    List<String> getMyBookPictures(@Param("type")Short type, @Param("userId")Integer userId);

}
