package com.prateekj.repositories;

import com.prateekj.models.Author;
import com.prateekj.setup.TestSetup;
import org.junit.Before;
import org.junit.Test;

import static com.prateekj.Utils.TestUtils.isNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class AuthorRepositoryTest extends TestSetup{
  @Before
  public void setUp() throws Exception {
    clearContent();
  }

  @Test
  public void shouldAddAuthor(){
    Author prateek = new Author();
    prateek.setName("Prateek");

    Author savedPrateek = authorRepository.save(prateek);

    assertThat(savedPrateek.getName(), is(prateek.getName()));
    assertTrue(isNotNull(savedPrateek.getId()));
  }

}