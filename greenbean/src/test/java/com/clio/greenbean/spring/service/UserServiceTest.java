package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

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
        Mockito.doAnswer((InvocationOnMock invocation)->{
            User mockUser = invocation.getArgument(0);
            Mockito.when(mockUser.getId()).thenReturn(666);
            return null;
        }).when(mockUserMapper).insertUserBasicInfo(Mockito.any(User.class));
        User mockUser = Mockito.mock(User.class);
        userService.insertUser(mockUser);
        // 验证调用顺序
        InOrder inOrder = Mockito.inOrder(mockUserMapper);
        inOrder.verify(mockUserMapper).insertUserBasicInfo(mockUser);
        inOrder.verify(mockUserMapper).insertUserAuthority(666,mockUser.getAuthority());
    }
    
    @Test
    void testValidateUsernameDuplicated(){
        Mockito.when(mockUserMapper.getUserByUsername("a")).thenReturn(Mockito.mock(User.class));
        Mockito.when(mockUserMapper.getUserByUsername("b")).thenReturn(null);
        boolean validateUserA = userService.validateUsernameDuplicated("a");
        boolean validateUserB = userService. validateUsernameDuplicated("b");
        Assertions.assertEquals(false, validateUserA);
        Assertions.assertEquals(true, validateUserB);
    }
    
}
