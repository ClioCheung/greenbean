package com.clio.greenbean.spring.controller;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/13
 */
@Controller
public class SignController {
    
    private UserMapper userMapper;
    
    @Autowired
    public SignController(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    
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
    
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(User user){
        // XXX 这里的 BCryptPasswordEncoder是否可以使用单例
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String userPassword = user.getPassword();
        String bcryptPassword = bCryptPasswordEncoder.encode(userPassword);
        user.setPassword(bcryptPassword);
        user.setEnabled(true);
        List<String> authority = new ArrayList<>();
        String userAuthority = "user";
        authority.add(userAuthority);
        user.setAuthority(authority);
        
        userMapper.insertUser(user);
        return "signUpSuccess";
        
    }
}
