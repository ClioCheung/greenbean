package com.clio.greenbean.spring.controller;

import com.clio.greenbean.spring.service.MyBookService;
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
 * created by 吾乃逆世之神也 on 2019/11/8
 */
class HomeControllerTest {
    
    private MockMvc mockMvc;
    
    @BeforeEach
    void setup(){
        //在test中重新配置视图解析器
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/template/");
        viewResolver.setSuffix(".html");
        MyBookService myBookService = Mockito.mock(MyBookService.class);
        UserService userService = Mockito.mock(UserService.class);
        HomeController homeController = new HomeController(myBookService, userService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).setViewResolvers(viewResolver).build();
    }
    
    @Test
    void TestHome() throws Exception {
        mockMvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }
}