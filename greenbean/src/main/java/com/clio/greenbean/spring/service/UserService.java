package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务类
 * created by 吾乃逆世之神也 on 2019/10/23
 */

@Service
public class UserService {
    
    private UserMapper userMapper;
    
    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    
    /**
     * 插入用户相关的数据
     * @param user 用户数据
     * @throws UsernameDuplicatedException 如果插入的用户数据中的用户名已存在，则抛出此异常
     */
    @Transactional
    public void insertUser(User user) throws UsernameDuplicatedException {
        if (this.validateUsernameDuplicated(user.getUsername())) {
            userMapper.insertUserBasicInfo(user);
            userMapper.insertUserAuthority(user.getId(),user.getAuthority());
        } else{
            throw new UsernameDuplicatedException("Username: [" + user.getUsername() + "] has existed in database.");
        }
    }
    
    @Cacheable(cacheNames="greenbean", key="'validateUsernameDuplicated'.concat(#username)")
    public boolean validateUsernameDuplicated(String username) {
        User result = userMapper.getUserByUsername(username);
        return result == null;
    }
    
    @Cacheable(cacheNames="greenbean", key="'getUserByUsername'.concat(#username)")
    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }
    
}
