package com.prateekj.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prateekj.makers.PublisherMaker;
import com.prateekj.models.Author;
import com.prateekj.models.Book;
import com.prateekj.models.Publisher;
import com.prateekj.setup.TestSetup;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.AuthorMaker.Author;
import static com.prateekj.makers.AuthorMaker.name;
import static com.prateekj.makers.BookMaker.Book;
import static com.prateekj.makers.BookMaker.author;
import static com.prateekj.makers.BookMaker.publisher;
import static com.prateekj.makers.BookMaker.title;
import static com.prateekj.makers.PublisherMaker.Publisher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class BookControllerTest extends TestSetup{
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;


  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    clearContent();
  }

  @Test
  public void shouldSaveTheBook() throws Exception{
    Author someAuthor = make(a(Author, with(name, "author-name")));
    Publisher somePublisher = make(a(Publisher, with(PublisherMaker.name, "publisher-name")));
    Book bookToBeSaved = make(a(Book, with(title, "book-title"),
        with(author, someAuthor),
        with(publisher, somePublisher)));

    String stringContent = new ObjectMapper().writeValueAsString(bookToBeSaved);
    mockMvc.perform(post("/book/add").contentType(MediaType.APPLICATION_JSON).content(stringContent))
        .andExpect(status().isCreated());
  }

}