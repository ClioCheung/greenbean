package com.clio.greenbean.spring.component.security;

import com.clio.greenbean.domain.User;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * created by 吾乃逆世之神也 on 2019/12/23
 */
@Component
public class SignInSuccessHandler implements AuthenticationSuccessHandler {
    
    private UserService userService;
    
    @Autowired
    public SignInSuccessHandler(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
    
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUsername());
        session.setAttribute("userNickName",user.getNickName());
        session.setAttribute("userAvatar", user.getAvatar());
        
        httpServletResponse.sendRedirect("home");
    }
}
