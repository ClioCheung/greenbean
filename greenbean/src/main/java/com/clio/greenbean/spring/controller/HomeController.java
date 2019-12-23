package com.clio.greenbean.spring.controller;

import com.clio.greenbean.config.GreenbeanConfig;
import com.clio.greenbean.spring.service.MyBookService;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    
    @RequestMapping(value="/home")
    public String home(Model model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        
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
}
