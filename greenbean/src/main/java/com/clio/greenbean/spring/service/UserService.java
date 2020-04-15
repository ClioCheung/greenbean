package com.clio.greenbean.spring.service;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 用户服务类
 * created by 吾乃逆世之神也 on 2019/10/23
 */

@Service
public class UserService {
    
    private UserMapper userMapper;
    
    // XXX 解决与DispatcherServletConfig重复
    // XXX 把properties映射成全局变量
    @Value("${picturesPath}")
    private String picturesPath;
    
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

    @CacheEvict(cacheNames="greenbean", key="'getUserByUsername'.concat(#username)")
    public void updateUserNickname(String username, String nickname){
        userMapper.updateUserNickname(username, nickname);
    }
    
    @CacheEvict(cacheNames="greenbean", key="'getUserByUsername'.concat(#username)")
    public String updateAvatar(String username, MultipartFile avatar) throws IOException {
        String avatarFilename = null;
        if(avatar != null) {
            // 使用UUID替换原上传头像的名称,并保留原后缀名
            String avatarOriginalFilename = avatar.getOriginalFilename();
            String avatarExtensionName = avatarOriginalFilename.substring(avatarOriginalFilename.lastIndexOf('.'));
            String uuid = UUID.randomUUID().toString();
            avatarFilename = uuid + avatarExtensionName;
        
            String homePath = System.getProperty("user.home").replaceAll("\\\\",
                "/");
            String path = homePath + this.picturesPath;
            File avatarFolder = new File(path + "avatars/");
            if(!avatarFolder.exists()){
                avatarFolder.mkdir();
            }
            File avatarFile = new File(avatarFolder, avatarFilename);
            // TODO delete old avatar
            avatar.transferTo(avatarFile.toPath());
            userMapper.updateAvatar(username, avatarFilename);
        }
        return avatarFilename;
    }
}
