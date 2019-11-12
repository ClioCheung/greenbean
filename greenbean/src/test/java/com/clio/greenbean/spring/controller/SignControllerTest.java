package com.clio.greenbean.spring.controller;

import com.clio.greenbean.exception.UsernameDuplicatedException;
import com.clio.greenbean.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * created by 吾乃逆世之神也 on 2019/11/9
 */
class SignControllerTest {
    private static String existedUsername = "exist";
    private static String notExistedUsername = "notExist";
    private static  String defaultPassword = "password";
    
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
  
    @Test
    void TestSignUp() throws Exception {
        mockMvc.perform(post("/signUp")
                        .param("username", notExistedUsername)
                        .param("password", defaultPassword)
                        .param("confirmPassword", defaultPassword))
        .andExpect(view().name("signUpSuccess"));
        Mockito.verify(mockUserService).insertUser(Mockito.argThat(user -> user.getUsername().equals(notExistedUsername)));
    }
    
    @Test
    void TestSignUpWithValidatedUsername() throws Exception {
        Mockito.doThrow(UsernameDuplicatedException.class).when(mockUserService)
            .insertUser(Mockito.argThat(user -> user.getUsername().equals(existedUsername)));
        mockMvc.perform(post("/signUp")
                        .param("username", existedUsername)
                        .param("password", defaultPassword)
                        .param("confirmPassword", defaultPassword))
        .andExpect(view().name("signUpFail"));
    }
    
    @Test
    void testSignUpValidatedUsername() throws Exception {
        Mockito.when(mockUserService.validateUsernameDuplicated(notExistedUsername)).thenReturn(true);
        mockMvc.perform(get("/signUp/validateUsername")
                        .param("username", notExistedUsername))
            .andExpect(status().isOk())
            .andExpect(content().contentType("text/plain"))
            .andExpect(content().encoding("utf-8"))
            .andExpect(content().string("true"));
    }
    
    @Test
    void testSignUpValidatedUsernameWithDuplicatedUsername() throws Exception {
        Mockito.when(mockUserService.validateUsernameDuplicated(existedUsername)).thenReturn(false);
        mockMvc.perform(get("/signUp/validateUsername")
                        .param("username", existedUsername))
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain"))
        .andExpect(content().encoding("utf-8"))
        .andExpect(content().string("false"));
    }
}
