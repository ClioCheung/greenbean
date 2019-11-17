package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public interface UserMapper {
    
    // 第一步 test version : XXX-mybatis.xml
    // 第二步 add  XXX-mybatis.xml 分支
    // 第三步 准备merge到dev分支,并delete XXX-mybatis.xml分支
    @SuppressWarnings("unused")
    User getUserQById(@Param("id") Integer id);
    
    User getUserByUsername(String username);
    
    void insertUserBasicInfo(User user);
    
    void insertUserAuthority(@Param("userId") Integer userId, @Param("authority") List<String> authority);
    
   
}
