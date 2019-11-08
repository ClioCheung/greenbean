package com.clio.greenbean.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by 吾乃逆世之神也 on 2019/10/15
 */
@Controller
public class HomeController {
    
    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String home(){
        return "home";
    }
}
