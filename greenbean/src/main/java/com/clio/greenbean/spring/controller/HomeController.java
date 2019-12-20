package com.clio.greenbean.spring.controller;

import com.clio.greenbean.config.GreenbeanConfig;
import com.clio.greenbean.domain.User;
import com.clio.greenbean.spring.service.MyBookService;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
    public String home(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Integer readingCount = myBookService.getMyBookCount(GreenbeanConfig.READING_BOOK_TYPE, user.getId());
        Integer readCount = myBookService.getMyBookCount(GreenbeanConfig.READ_BOOK_TYPE, user.getId());
        Integer wishCount = myBookService.getMyBookCount(GreenbeanConfig.WISH_BOOK_TYPE, user.getId());
        model.addAttribute("readingCount",readingCount);
        model.addAttribute("readCount",readCount);
        model.addAttribute("wishCount",wishCount);
        return "home";
    }
}
