package com.clio.greenbean.spring.controller;

import com.clio.greenbean.config.GreenbeanConfig;
import com.clio.greenbean.domain.User;
import com.clio.greenbean.spring.service.MyBookService;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

/**
 * created by 吾乃逆世之神也 on 2019/10/15
 */
@Controller
public class HomeController {
    
    private MyBookService myBookService;
    private UserService userService;
    
    @Autowired
    public HomeController(MyBookService myBookService, UserService userService) {
        this.myBookService = myBookService;
        this.userService = userService;
    }
  
    @RequestMapping(value="home")
    public String home(Model model, Principal principal){
        //XXX 直接从session拿username即可，检查所有controller获取username或userId的方法
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Integer userId = user.getId();
        
        Integer readingCount = myBookService.getMyBookCount(GreenbeanConfig.READING_BOOK_TYPE, userId);
        Integer readCount = myBookService.getMyBookCount(GreenbeanConfig.READ_BOOK_TYPE, userId);
        Integer wishCount = myBookService.getMyBookCount(GreenbeanConfig.WISH_BOOK_TYPE, userId);
        model.addAttribute("readingCount",readingCount);
        model.addAttribute("readCount",readCount);
        model.addAttribute("wishCount",wishCount);
    
        List<String> readingBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.READING_BOOK_TYPE, userId);
        List<String> readBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.READ_BOOK_TYPE, userId);
        List<String> wishBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.WISH_BOOK_TYPE, userId);
        model.addAttribute("readingBookPictures",readingBookPictures);
        model.addAttribute("readBookPictures",readBookPictures);
        model.addAttribute("wishBookPictures",wishBookPictures);
       
        return "home";
    }
    
    @RequestMapping(value="/setting")
    public String setting(){
        return "setting";
    }
    
    @RequestMapping(value="/updateSettings")
    @ResponseBody
    public String updateSettings(@RequestParam(value="nickname") String nickname, @RequestParam(value="avatar", required=false) MultipartFile avatar, Principal principal, HttpSession session) throws IOException {
        String username = principal.getName();
        userService.updateUserNickname(username, nickname);
        session.setAttribute("userNickname", nickname);
        //XXX 把上传图片抽取成公共方法或工具类
        String avatarFilename = userService.updateAvatar(username, avatar);
        session.setAttribute("userAvatar",avatarFilename);
        return avatarFilename;
    }
}
