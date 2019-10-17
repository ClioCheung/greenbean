package com.clio.greenbean.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by 吾乃逆世之神也 on 2019/10/13
 */
@Controller
public class SignController {
    
    @RequestMapping("/signIn")
    public String signIn(){
        return "signIn";
    }
    
    // Login form with error
    @RequestMapping("/signInError")
    public String loginError(Model model) {
        model.addAttribute("signInError", true);
        return "signIn";
    }
}
