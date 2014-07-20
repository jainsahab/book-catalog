package com.prateekj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class HomeController {

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ModelAndView getHomePage(){
    ModelAndView indexPage = new ModelAndView("index");
    return indexPage;
  }
}
