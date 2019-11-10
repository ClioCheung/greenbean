package com.clio.greenbean.spring.controller;

import com.clio.greenbean.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * created by 吾乃逆世之神也 on 2019/11/9
 */
class SignControllerTest {
    
    private MockMvc mockMvc;
    private UserService mockUserService;
    
    @SuppressWarnings("unused")
    @BeforeEach
    private void setup(){
        //配置视图解析器
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/template/");
        viewResolver.setSuffix(".html");
        mockUserService = Mockito.mock(UserService.class);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SignController(mockUserService)).setViewResolvers(viewResolver).build();
    }
    
    @Test
    void testSignIn() throws Exception {
        mockMvc.perform(get("/signIn"))
            .andExpect(status().isOk())
            .andExpect(view().name("signIn"));
    }
    
    @Test
    void testSignInError() throws Exception {
        mockMvc.perform(get("/signInError"))
        .andExpect(status().isOk())
        .andExpect(view().name("signIn"));
    }
    
 /*   *//**
     * Argument(s) are different!
     * @throws Exception
     *//*
    @Test
    void TestSignUp() throws Exception {
        String username = "oo";
        String password = "oo";
        String confirmPassword = "oo";
        mockMvc.perform(post("/signUp")
                        .param("username", username)
                        .param("password", password)
                        .param("confirmPassword", confirmPassword))
        .andExpect(view().name("signUpSuccess"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(true);
        List<String> authorities  = new ArrayList<>();
        String authority = "USER";
        authorities.add(authority);
        user.setAuthority(authorities);
        Mockito.verify(mockUserService).insertUser(user);
    }*/
}
