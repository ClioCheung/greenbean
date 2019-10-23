package com.clio.greenbean.mybatis.mapper;

import com.clio.greenbean.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
public interface UserMapper {
    @Select("select * from t_user where id = #{id}")
    User getUserById(@Param("id") Integer id);
    
    @Select("insert into t_user (username,password,enabled)" +
            " values(#{username},#{password},#{enabled})")
    void insertUser(User user);
}
