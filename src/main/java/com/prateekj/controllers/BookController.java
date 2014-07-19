package com.prateekj.controllers;

import com.prateekj.models.Book;
import com.prateekj.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<Void> addBook(@RequestBody Book book){
    bookService.addBook(book);
    return new ResponseEntity<Void>(CREATED);
  }
}
