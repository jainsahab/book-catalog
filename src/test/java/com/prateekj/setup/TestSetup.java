package com.prateekj.setup;

import com.prateekj.repositories.AuthorRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/configuration/services-config.xml"})

public class TestSetup {
  @Autowired
  protected AuthorRepository authorRepository;

  protected boolean isNotNull(Object object){
    return object != null;
  }

  @Before
  public void setUp() throws Exception {
    authorRepository.deleteAll();
  }
}
