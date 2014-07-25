package com.prateekj.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prateekj.models.Author;
import com.prateekj.setup.TestSetup;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.AuthorMaker.Author;
import static com.prateekj.makers.AuthorMaker.name;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class AuthorControllerTest extends TestSetup{
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;


  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    clearContent();
  }

  @Test
  public void shouldGetAllAuthors() throws Exception{
    Author author1 = make(a(Author));
    Author author2 = make(a(Author));
    authorRepository.save(asList(author1, author2));

    mockMvc.perform(get("/author/all")
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[*]").value(hasSize(2)))
        .andExpect(jsonPath("$.[*].name[*]").value(hasItems(author1.getName(), author2.getName())));
  }

  @Test
  public void shouldSaveTheAuthors() throws Exception{
    String authorName = "Prateek";
    Author author = make(a(Author, with(name, authorName)));
    authorRepository.save(asList(author));

    mockMvc.perform(put("/author/save")
        .content(new ObjectMapper().writeValueAsString(author))
        .contentType(APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value(author.getName()))
        .andExpect(jsonPath("$.id").value(notNullValue()));
  }
}