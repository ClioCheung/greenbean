package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by 吾乃逆世之神也 on 2019/10/23
 */
@Service
public class UserService {
    
    private UserMapper userMapper;
    
    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Transactional
    public void insertUser(User user) throws UsernameDuplicatedException {
        if (validateUsernameDuplicated(user.getUsername())) {
            userMapper.insertUserBasicInfo(user);
            userMapper.insertUserAuthority(user.getId(),user.getAuthority());
        } else{
            throw new UsernameDuplicatedException("Username: [" + user.getUsername() + "] has existed in database.");
        }
    }
    
    public boolean validateUsernameDuplicated(String username) {
        Integer result = userMapper.getUserByUsername(username);
        return result == null;
    }
}
