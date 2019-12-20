package com.clio.greenbean.spring.controller;

import com.clio.greenbean.spring.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by 吾乃逆世之神也 on 2019/10/15
 */
@Controller
public class HomeController {
    
    private MyBookService myBookService;
    
    @Autowired
    public HomeController(MyBookService myBookService) {
        this.myBookService = myBookService;
    }
    
    @RequestMapping(value="/home")
    public String home(Model model){
        
        return "home";
    }
}
