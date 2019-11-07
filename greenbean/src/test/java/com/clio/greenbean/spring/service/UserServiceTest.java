package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/11/1
 */
class UserServiceTest {
    private static String existedUsername = "exist";
    private static String notExistedUsername = "notExist";
    
    private static UserService userService;
    private static UserMapper mockUserMapper;
    
    @BeforeAll
    static void setUp(){
        mockUserMapper = Mockito.mock(UserMapper.class);
        userService = new UserService(mockUserMapper);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    void testInsertUser(){
        int mockUserId = 666;
//        使用spy
//        userService = Mockito.spy(userService);
//        Mockito.doReturn(true).when(userService).validateUsernameDuplicated(notExistedUsername);
//       不使用spy
        Mockito.when(mockUserMapper.getUserByUsername(notExistedUsername)).thenReturn(null);
        // 返回模仿的用户ID ： mockUserId
        Mockito.doAnswer((InvocationOnMock invocation)->{
            User mockUser = invocation.getArgument(0);
            Mockito.when(mockUser.getId()).thenReturn(mockUserId);
            return null;
        }).when(mockUserMapper).insertUserBasicInfo(Mockito.any(User.class));
        
        User mockUser = Mockito.mock(User.class);
        Mockito.when(mockUser.getUsername()).thenReturn(notExistedUsername);
        // 返回模仿的权限 ： mockAuthority
        List<String> mockAuthority = Mockito.mock(List.class);
        Mockito.when(mockAuthority.get(0)).thenReturn("USER");
        Mockito.when(mockUser.getAuthority()).thenReturn(mockAuthority);
        
        userService.insertUser(mockUser);
        // 验证调用顺序
        InOrder inOrder = Mockito.inOrder(mockUserMapper);
        inOrder.verify(mockUserMapper).insertUserBasicInfo(mockUser);
        inOrder.verify(mockUserMapper).insertUserAuthority(mockUserId,mockAuthority);
    }
    
    @Test
    void testInsertUserWithDuplicatedUsername() {
        Mockito.when(mockUserMapper.getUserByUsername(existedUsername)).thenReturn(Mockito.mock(User.class));
        User mockUser =  Mockito.mock(User.class);
        Mockito.when(mockUser.getUsername()).thenReturn(existedUsername);
        Assertions.assertThrows(UsernameDuplicatedException.class, ()-> userService.insertUser(mockUser));
    }
    
    @Test
    void testValidateUsernameDuplicatedExist(){
        Mockito.when(mockUserMapper.getUserByUsername(existedUsername)).thenReturn(Mockito.mock(User.class));
        boolean validateUserA = userService.validateUsernameDuplicated(existedUsername);
        Assertions.assertFalse(validateUserA);
    }
    
    @Test
    void testValidateUsernameDuplicatedNotExist(){
        Mockito.when(mockUserMapper.getUserByUsername(notExistedUsername)).thenReturn(null);
        boolean validateUserB = userService. validateUsernameDuplicated(notExistedUsername);
        Assertions.assertTrue(validateUserB);
    }
    
}
