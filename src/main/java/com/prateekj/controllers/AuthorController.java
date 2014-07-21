package com.prateekj.controllers;

import com.prateekj.models.Author;
import com.prateekj.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/author")
public class AuthorController {

  @Autowired
  private AuthorService bookService;

  @RequestMapping(value = "/all", method = GET)
  public ResponseEntity<List<Author>> addBook(){
    List<Author> allAuthors = bookService.getAllAuthors();
    return new ResponseEntity<List<Author>>(allAuthors , OK);
  }
}
