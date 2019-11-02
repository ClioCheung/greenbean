package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * created by 吾乃逆世之神也 on 2019/11/1
 */
public class UserServiceTest {
    
    @Test
    void testInsertUser() throws NoSuchFieldException, IllegalAccessException {
        UserMapper mockUserMapper = Mockito.mock(UserMapper.class);
        UserService userService = new UserService(mockUserMapper);
        User mockUser = Mockito.mock(User.class);
        
/*      利用反射机制获取UserService.class的属性UserMapper
//      环境搭建
        UserService userService = new UserService();
        User mockUser = Mockito.mock(User.class);
//      依赖UserMapper
        UserMapper mockUserMapper = Mockito.mock(UserMapper.class);
        Class<UserService> UserServiceClass = UserService.class;
        Field userMapperField = UserServiceClass.getDeclaredField("userMapper");
        userMapperField.setAccessible(true);
        userMapperField.set(userService,mockUserMapper);*/
        
        userService.insertUser(mockUser);
//      验证调用顺序
        InOrder inOrder = Mockito.inOrder(mockUserMapper);
        inOrder.verify(mockUserMapper).insertUserBasicInfo(mockUser);
        inOrder.verify(mockUserMapper).insertUserAuthority(mockUser.getId(),mockUser.getAuthority());
    }
    
}
