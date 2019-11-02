package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * created by 吾乃逆世之神也 on 2019/11/1
 */
class UserServiceTest {
    private static UserService userService;
    private static UserMapper mockUserMapper;
    
    @BeforeAll
    static void setUp(){
        mockUserMapper = Mockito.mock(UserMapper.class);
        userService = new UserService(mockUserMapper);
    }
    
    @Test
    void testInsertUser(){
        User mockUser = Mockito.mock(User.class);
        userService.insertUser(mockUser);
//      验证调用顺序
        InOrder inOrder = Mockito.inOrder(mockUserMapper);
        inOrder.verify(mockUserMapper).insertUserBasicInfo(mockUser);
        inOrder.verify(mockUserMapper).insertUserAuthority(mockUser.getId(),mockUser.getAuthority());
    }
    
    @Test
    void TestInsertUserWithNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> userService.insertUser(null));
        Mockito.verify(mockUserMapper,Mockito.never()).insertUserBasicInfo(Mockito.any());
        Mockito.verify(mockUserMapper,Mockito.never()).insertUserAuthority(Mockito.any(),Mockito.any());
    }
    
}
