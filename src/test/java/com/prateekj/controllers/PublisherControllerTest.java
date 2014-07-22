package com.prateekj.controllers;

import com.prateekj.models.Publisher;
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
import static com.prateekj.makers.PublisherMaker.Publisher;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class PublisherControllerTest extends TestSetup{
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
    Publisher publisher1 = make(a(Publisher));
    Publisher publisher2 = make(a(Publisher));
    publisherRepository.save(asList(publisher1, publisher2));

    mockMvc.perform(get("/publisher/all")
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[*]").value(hasSize(2)))
        .andExpect(jsonPath("$.[*].name[*]").value(hasItems(publisher1.getName(), publisher2.getName())));
  }


}