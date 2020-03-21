package com.clio.greenbean.spring.controller;

import com.clio.greenbean.dto.BookDTO;
import com.clio.greenbean.dto.BookPageDTO;
import com.clio.greenbean.dto.SearchPageDTO;
import com.clio.greenbean.dto.UserRatingDTO;
import com.clio.greenbean.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/12/29
 */
@Controller
public class BookController {
    private BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/search")
    public String search(String searchKeyWord, Integer offset, Model model){
        if(offset == null) {
            offset = 0;
        }
        SearchPageDTO searchPageDTO = bookService.getSearchPage(searchKeyWord, offset);
        model.addAttribute("searchBooks",searchPageDTO.getBookItemsList());
        model.addAttribute("pagination",searchPageDTO.getPaginationVo());
        return "search";
    }
    
    @RequestMapping(value="/addBook")
    public String addBookPage(){
        return "addBook";
    }
    
    @PostMapping(value="/book")
    //TODO 表单数据的验证 并去掉字符串前后的空格
    public void addBook(BookDTO bookDTO, HttpServletResponse httpServletResponse) throws IOException {
        removeBlankNames(bookDTO.getAuthor());
        removeBlankNames(bookDTO.getTranslator());
        this.bookService.saveBook(bookDTO);
        httpServletResponse.sendRedirect("addBookSuccess");
    }
    
    @GetMapping(value="/addBookSuccess")
    public String addBookSuccess(){
        return "addBookSuccess";
    }
    
    private void removeBlankNames(List<String> nameList){
        Iterator<String> iterator = nameList.iterator();
        while (iterator.hasNext()){
            //XXX Iterator removeIf
            if(StringUtils.isEmptyOrWhitespace(iterator.next())){
                iterator.remove();
            }
        }
    }
    
    @GetMapping(value="/getAuthorSuggestion")
    @ResponseBody
    public List<String> getAuthorSuggestion(String keyword){
        return this.bookService.getAuthorSuggestion(keyword);
    }
    
    @GetMapping(value="/getTranslatorSuggestion")
    @ResponseBody
    public List<String> getTranslatorSuggestion(String keyword){
        return this.bookService.getTranslatorSuggestion(keyword);
    }
    
    //TODO 出错视图
    
    @GetMapping(value="/book/{id}")
    public String showBook(@PathVariable Integer id, HttpSession session, Model model){
        Integer userId = (Integer) session.getAttribute("userId");
        BookPageDTO bookPageDTO = this.bookService.getBookPageDTO(id, userId);
        model.addAttribute("bookPage",bookPageDTO);
        return "book";
    }
    
    @PostMapping(value="/saveOrUpdateUserRating")
    public void saveOrUpdateUserRating(UserRatingDTO userRatingDto, HttpSession session, HttpServletResponse response) throws IOException {
        // TODO 验证表单是否为空 如userId为null
        userRatingDto.setUserId((Integer)session.getAttribute("userId"));
        this.bookService.saveOrUpdateUserRating(userRatingDto);
        response.sendRedirect("book/" + userRatingDto.getBookId());
    }
    
    @PostMapping(value = "/removeUserRating")
    public void removeUserRating(Integer bookId, HttpSession session, HttpServletResponse response) throws IOException {
        // TODO 验证表单格式等
        Integer userId = (Integer) session.getAttribute("userId");
        this.bookService.removeUserRating(bookId, userId);
        response.sendRedirect("book/" + bookId);
    }
}

