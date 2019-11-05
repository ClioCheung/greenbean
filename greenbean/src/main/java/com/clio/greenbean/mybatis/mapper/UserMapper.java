package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public interface UserMapper {
    
    @SuppressWarnings("unused")
    @Select("select * from t_user where id = #{id}")
    User getUserQById(@Param("id") Integer id);
    
    @Select("select * from t_user where username = #{username}")
    Integer getUserByUsername(@Param("username") String username);
    
    @Insert("insert into t_user (username,password,enabled)" +
            " values(#{user.username},#{user.password},#{user.enabled})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "user.id", resultType = Integer.class, before = false)
    void insertUserBasicInfo(@Param("user") User user);
    
    @Insert({
            "<script>" +
            "insert into t_authority(user_id,authority)" +
            " values" +
            "<foreach item='value' collection='authority' separator=','>" +
            "(#{user_id},#{value})" +
            "</foreach>" +
            "</script>"
    })
    void insertUserAuthority(@Param("user_id") Integer userId, @Param("authority") List<String> authority);
    
   
}
