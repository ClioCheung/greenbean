package com.clio.greenbean.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * created by 吾乃逆世之神也 on 2019/12/29
 */
@Controller
public class BookController {
    
    @GetMapping("/search")
    public String search(String searchKeyWord){
        return "search";
    }
}