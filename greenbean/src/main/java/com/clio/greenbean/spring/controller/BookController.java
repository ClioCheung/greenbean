package com.clio.greenbean.spring.controller;

import com.clio.greenbean.dto.SearchBookItemsDTO;
import com.clio.greenbean.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String search(String searchKeyWord, Integer start, Model model){
        if(start == null) {
            start = 0;
        }
        List<SearchBookItemsDTO> searchBooks = bookService.getSearchBooks(searchKeyWord,start);
        model.addAttribute("searchBooks",searchBooks);
        return "search";
    }
}