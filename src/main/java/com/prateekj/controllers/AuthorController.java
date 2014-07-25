package com.prateekj.controllers;

import com.prateekj.models.Author;
import com.prateekj.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/author")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @RequestMapping(value = "/all", method = GET)
  public ResponseEntity<List<Author>> addBook(){
    List<Author> allAuthors = authorService.getAllAuthors();
    return new ResponseEntity<List<Author>>(allAuthors , OK);
  }

  @RequestMapping(value = "/save", method = PUT)
  public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
    author = authorService.saveAuthor(author);
    return new ResponseEntity<Author>(author , CREATED);
  }
}
