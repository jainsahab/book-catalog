package com.prateekj.repositories;

import com.prateekj.makers.PublisherMaker;
import com.prateekj.models.Author;
import com.prateekj.models.Book;
import com.prateekj.models.Publisher;
import com.prateekj.setup.TestSetup;
import org.junit.Before;
import org.junit.Test;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.AuthorMaker.Author;
import static com.prateekj.makers.AuthorMaker.name;
import static com.prateekj.makers.BookMaker.Book;
import static com.prateekj.makers.BookMaker.author;
import static com.prateekj.makers.BookMaker.publisher;
import static com.prateekj.makers.PublisherMaker.Publisher;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookRepositoryTest extends TestSetup{
  @Before
  public void setUp() throws Exception {
    clearContent();
  }

  @Test
  public void shouldAddABook(){
    Author aAuthor = authorRepository.save(make(a(Author, with(name, "some-name"))));
    Publisher aPublisher = publisherRepository.save(make(a(Publisher, with(PublisherMaker.name, "some-publisher-name"))));
    Book aBook = make(a(Book, with(author, aAuthor), with(publisher, aPublisher)));

    Book savedBook = bookRepository.save(aBook);

    assertThat(savedBook.getAuthor(), is(aAuthor));
    assertThat(savedBook.getPublisher(), is(aPublisher));
  }
}