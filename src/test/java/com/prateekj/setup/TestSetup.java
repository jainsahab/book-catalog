package com.prateekj.setup;

import com.prateekj.repositories.AuthorRepository;
import com.prateekj.repositories.BookRepository;
import com.prateekj.repositories.PublisherRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/configuration/services-config.xml", "classpath:/configuration/mvc-dispatcher-config.xml"})
@Ignore
public class TestSetup {
  @Autowired
  protected AuthorRepository authorRepository;

  @Autowired
  protected PublisherRepository publisherRepository;

  @Autowired
  protected BookRepository bookRepository;

  @Before
  public void setUp() throws Exception {
    bookRepository.deleteAll();
    authorRepository.deleteAll();
    publisherRepository.deleteAll();
  }
}
