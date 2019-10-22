package com.clio.greenbean.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by 吾乃逆世之神也 on 2019/10/13
 */
@Controller
public class SignController {
    
    @RequestMapping(value = "/signIn",method = RequestMethod.GET)
    public String signIn(){
        return "signIn";
    }
    
    // Login form with error
    @RequestMapping("/signInError")
    public String loginError(Model model) {
        model.addAttribute("signInError", true);
        return "signIn";
    }
    @RequestMapping(value = "/signUp",method = RequestMethod.GET)
    public String signUp(){
        return "signUpSuccess";
    }
}
