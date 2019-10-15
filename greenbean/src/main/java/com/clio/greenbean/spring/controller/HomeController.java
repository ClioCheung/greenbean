package com.clio.greenbean.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by 吾乃逆世之神也 on 2019/10/15
 */
@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
