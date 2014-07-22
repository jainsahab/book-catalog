package com.prateekj.controllers;

import com.prateekj.models.Publisher;
import com.prateekj.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

  @Autowired
  private PublisherService publisherService;

  @RequestMapping(value = "/all", method = GET)
  public ResponseEntity<List<Publisher>> addBook(){
    List<Publisher> allPublisher = publisherService.getAllPublisher();
    return new ResponseEntity<List<Publisher>>(allPublisher , OK);
  }
}
