package com.clio.greenbean.spring.service;

import com.clio.greenbean.mybatis.mapper.MyBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/12/20
 */
@Service
public class MyBookService {
    
    private MyBookMapper myBookMapper;
    
    @Value("${bookPicturesPath}")
    private String bookPicturesPath;
    
    @Autowired
    public MyBookService(MyBookMapper myBookMapper) {
        this.myBookMapper = myBookMapper;
    }
    
    public Integer getMyBookCount(Short type, Integer userId){
        return myBookMapper.getMyBookCount(type, userId);
    }
    
    public List<String> getMyBookPictures(Short type, Integer userId){
        List<String> myBookPicturesPath = myBookMapper.getMyBookPictures(type, userId);
        String homePath = System.getProperty("user.home").replace("\\", "/");
        String path = homePath + bookPicturesPath;
        
        List<String> myBookPicturesRealPath = new ArrayList<>();
        for(String myBookPicturePath : myBookPicturesPath){
            myBookPicturesRealPath.add(path + myBookPicturePath);
        }
        return myBookPicturesRealPath;
    }
}
