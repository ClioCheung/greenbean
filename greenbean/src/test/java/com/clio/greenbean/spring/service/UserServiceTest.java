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

import java.util.ArrayList;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/11/1
 */
class UserServiceTest {
    private static String existedUsername = "exist";
    private static String notExistedUsername = "notExist";
    private static Integer userIdGeneratedByDatabase = 666;
    
    private static UserService userService;
    private static UserMapper mockUserMapper;
    
    @BeforeAll
    static void setup(){
        mockUserMapper = Mockito.mock(UserMapper.class);
        userService = new UserService(mockUserMapper);
    }
    
    @Test
    void testInsertUser(){
        Mockito.when(mockUserMapper.getUserByUsername(notExistedUsername)).thenReturn(null);
        
        User user =  this.generatedUser(false);
        Mockito.doAnswer((InvocationOnMock invocation)->{
            User userArgument = invocation.getArgument(0);
            userArgument.setId(userIdGeneratedByDatabase);
            return null;
        }).when(mockUserMapper).insertUserBasicInfo(user);
        
        userService.insertUser(user);
        // 验证调用顺序
        InOrder inOrder = Mockito.inOrder(mockUserMapper);
        inOrder.verify(mockUserMapper).insertUserBasicInfo(user);
        inOrder.verify(mockUserMapper).insertUserAuthority(userIdGeneratedByDatabase,user.getAuthority());
    }
    
    @Test
    void testInsertUserWithDuplicatedUsername() {
        User existUser =  this.generatedUser(true);
        Mockito.when(mockUserMapper.getUserByUsername(existedUsername)).thenReturn(existUser);
        User user = new User();
        user.setUsername(existedUsername);
        Assertions.assertThrows(UsernameDuplicatedException.class, ()-> userService.insertUser(user));
    }
    
    @Test
    void testValidateUsernameDuplicatedExist(){
        User existUser =  this.generatedUser(true);
        Mockito.when(mockUserMapper.getUserByUsername(existedUsername)).thenReturn(existUser);
        boolean validateUserA = userService.validateUsernameDuplicated(existedUsername);
        Assertions.assertFalse(validateUserA);
    }
    
    @Test
    void testValidateUsernameDuplicatedNotExist(){
        Mockito.when(mockUserMapper.getUserByUsername(notExistedUsername)).thenReturn(null);
        boolean validateUserB = userService. validateUsernameDuplicated(notExistedUsername);
        Assertions.assertTrue(validateUserB);
    }
    
    private User generatedUser(boolean exist){
        String defaultPassword = "password";
        Integer existId = 100;
        User user = new User();
        if(exist){
            user.setId(existId);
            user.setUsername(existedUsername);
        } else {
            user.setUsername(notExistedUsername);
        }
        user.setPassword(defaultPassword);
        user.setEnabled(true);
        List<String> authority = new ArrayList<>();
        authority.add("USER");
        user.setAuthority(authority);
        return user;
    }
}
