package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public interface UserMapper {
    
    // test version : XXX-mybatis.xml
    // add  XXX-mybatis.xml 分支
    @SuppressWarnings("unused")
    User getUserQById(@Param("id") Integer id);
    
    User getUserByUsername(String username);
    
    void insertUserBasicInfo(User user);
    
    void insertUserAuthority(@Param("userId") Integer userId, @Param("authority") List<String> authority);
    
   
}
