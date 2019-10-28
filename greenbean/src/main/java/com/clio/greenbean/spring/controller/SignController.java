package com.clio.greenbean.spring.controller;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.dto.UserDTO;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/13
 */
@Controller
public class SignController {
    private UserService userService;
    
    @Autowired
    public SignController(UserService userService){
        this.userService = userService;
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
    public String signUp(@Validated UserDTO userDTO, BindingResult bindingResult){
        // XXX 这里的 BCryptPasswordEncoder是否可以使用单例
        String viewResult = null;
        if (!bindingResult.hasErrors()){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String userPassword = userDTO.getPassword().trim();
            String bcryptPassword = bCryptPasswordEncoder.encode(userPassword);
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(bcryptPassword);
            user.setEnabled(true);
            List<String> authority = new ArrayList<>();
            String userAuthority = "user";
            authority.add(userAuthority);
            user.setAuthority(authority);
            userService.insertUser(user);
            viewResult = "signUpSuccess";
        } else {
            viewResult = "signUpFail";
        }
        return viewResult;
    }
    
    @RequestMapping(value = "signUp/validateUsername",method = RequestMethod.GET)
    @ResponseBody
    public String validateUsername(String username){
        boolean result = userService.validateUsername(username);
        return String.valueOf(result);
    }
}
