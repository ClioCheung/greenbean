package com.clio.greenbean.spring.controller;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.dto.UserDTO;
import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.spring.service.UserService;
import com.clio.greenbean.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
        // TODO 加上注册错误的提示内容
        // TODO 整理一下注册失败的页面处理
        model.addAttribute("signInError", true);
        return "signIn";
    }
    
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(@Validated UserDTO userDTO, BindingResult bindingResult,HttpServletResponse response){
        String viewResult = null;
        if (!bindingResult.hasErrors()){
            User user = generateUser(userDTO);
            userService.insertUser(user);
            viewResult = "signUpSuccess";
        } else {
            response.setStatus(403);
            viewResult = "signUpFail";
        }
        return viewResult;
    }
    
    private User generateUser(UserDTO userDTO){
        User user = new User();
        String userPassword = userDTO.getPassword().trim();
        String bcryptPassword = EncryptionUtils.encode(userPassword);
        user.setUsername(userDTO.getUsername());
        user.setPassword(bcryptPassword);
        user.setEnabled(true);
        List<String> authority = new ArrayList<>();
        String userAuthority = "user";
        authority.add(userAuthority);
        user.setAuthority(authority);
        return user;
    }
    
    
    @RequestMapping(value = "/signUp/validateUsername", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    // TODO 使用spring alidation 验证username
    public String signUpValidatedUsername(String username, HttpServletResponse httpServletResponse){
        boolean result = userService.validateUsernameDuplicated(username);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.TEXT_PLAIN_VALUE);
        return String.valueOf(result);
    }
    
    @ExceptionHandler(UsernameDuplicatedException.class)
    public String handleUsernameDuplicatedException(HttpServletResponse response){
        response.setStatus(403);
        return "signUpFail";
    }
}
