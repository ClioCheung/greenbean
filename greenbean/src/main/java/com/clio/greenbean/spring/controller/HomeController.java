package com.clio.greenbean.spring.controller;

import com.clio.greenbean.config.GreenbeanConfig;
import com.clio.greenbean.domain.User;
import com.clio.greenbean.spring.service.MyBookService;
import com.clio.greenbean.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

/**
 * created by 吾乃逆世之神也 on 2019/10/15
 */
@Controller
public class HomeController {
    
    private MyBookService myBookService;
    private UserService userService;
    
    @Autowired
    public HomeController(MyBookService myBookService, UserService userService) {
        this.myBookService = myBookService;
        this.userService = userService;
    }
    
    // XXX 解决与DispatcherServletConfig重复
    @Value("${picturesPath}")
    private String picturesPath;
    
    @RequestMapping(value="/home")
    public String home(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Integer userId = user.getId();
        
        Integer readingCount = myBookService.getMyBookCount(GreenbeanConfig.READING_BOOK_TYPE, userId);
        Integer readCount = myBookService.getMyBookCount(GreenbeanConfig.READ_BOOK_TYPE, userId);
        Integer wishCount = myBookService.getMyBookCount(GreenbeanConfig.WISH_BOOK_TYPE, userId);
        model.addAttribute("readingCount",readingCount);
        model.addAttribute("readCount",readCount);
        model.addAttribute("wishCount",wishCount);
    
        List<String> readingBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.READING_BOOK_TYPE, userId);
        List<String> readBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.READ_BOOK_TYPE, userId);
        List<String> wishBookPictures = myBookService.getMyBookPictures(GreenbeanConfig.WISH_BOOK_TYPE, userId);
        model.addAttribute("readingBookPictures",readingBookPictures);
        model.addAttribute("readBookPictures",readBookPictures);
        model.addAttribute("wishBookPictures",wishBookPictures);
       
        return "home";
    }
    
    @RequestMapping(value="/setting")
    public String setting(){
        return "setting";
    }
    
    @RequestMapping(value="/updateSettings")
    @ResponseBody
    public void updateSettings(@RequestParam(value="nickname") String nickname, @RequestParam(value="avatar", required=false) MultipartFile avatar, Principal principal, HttpSession session) throws IOException {
        String username = principal.getName();
        userService.updateUserNickname(username, nickname);
        session.setAttribute("userNickname", nickname);
        if(avatar != null) {
            // 使用UUID替换原上传头像的名称,并保留原后缀名
            String avatarOriginalFilename = avatar.getOriginalFilename();
            String avatarExtensionName = avatarOriginalFilename.substring(avatarOriginalFilename.lastIndexOf('.'));
            String uuid = UUID.randomUUID().toString();
            String avatarFilename = uuid + avatarExtensionName;
            
            String homePath = System.getProperty("user.home").replaceAll("\\\\", "/");
            String path = homePath + picturesPath;
            File avatarFolder = new File(path + "avatars/");
            if(!avatarFolder.exists()){
                avatarFolder.mkdir();
            }
            File avatarFile = new File(avatarFolder, avatarFilename);
            avatar.transferTo(avatarFile.toPath());
            
            userService.updateAvatar(username, avatarFilename);
            session.setAttribute("userAvatar",avatarFilename);
        }
        
    }
}
