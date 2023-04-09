package com.encray.spring6webapp.controller;

import com.encray.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }


  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public String getBooks(Model model){
    model.addAttribute("books", bookService.findAll());
    return "books";
  }
}
