package com.prateekj.services;

import com.prateekj.models.Author;
import com.prateekj.repositories.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.AuthorMaker.Author;
import static com.prateekj.makers.AuthorMaker.id;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

  @InjectMocks
  private AuthorService authorService;

  @Mock
  private AuthorRepository authorRepository;

  @Test
  public void shouldSaveTheBook(){
    Author aAuthor = make(a(Author));

    authorService.saveAuthor(aAuthor);

    verify(authorRepository, times(1)).save(aAuthor);
  }

  @Test
  public void shouldFindTheBookById(){
    Integer authorId = 1;
    Author savedAuthor = make(a(Author, with(id, authorId)));

    when(authorRepository.findOne(savedAuthor.getId())).thenReturn(savedAuthor);

    Author foundAuthor = authorService.findById(savedAuthor.getId());

    assertThat(foundAuthor, is(savedAuthor));
  }

}