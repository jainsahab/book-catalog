package com.prateekj.services;

import com.prateekj.makers.AuthorMaker;
import com.prateekj.makers.PublisherMaker;
import com.prateekj.models.Author;
import com.prateekj.models.Book;
import com.prateekj.models.Publisher;
import com.prateekj.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.AuthorMaker.Author;
import static com.prateekj.makers.BookMaker.Book;
import static com.prateekj.makers.BookMaker.author;
import static com.prateekj.makers.BookMaker.publisher;
import static com.prateekj.makers.PublisherMaker.Publisher;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

  @InjectMocks
  private BookService bookService;

  @Mock
  private AuthorService authorService;

  @Mock
  private PublisherService publisherService;

  @Mock
  private BookRepository bookRepository;


  @Test
  public void should_save_the_author_and_publisher_before_book_when_not_pre_saved(){
    Author unsavedAuthor = make(a(Author));
    Publisher unsavedPublisher = make(a(Publisher));
    Book unsavedBook = make(a(Book, with(author, unsavedAuthor), with(publisher, unsavedPublisher)));

    when(authorService.findById(unsavedAuthor.getId())).thenReturn(null);
    when(publisherService.findPublisherById(unsavedPublisher.getId())).thenReturn(null);

    bookService.addBook(unsavedBook);

    verify(authorService, times(1)).saveAuthor(unsavedAuthor);
    verify(publisherService, times(1)).savePublisher(unsavedPublisher);
    verify(bookRepository, times(1)).save(unsavedBook);
  }

  @Test
  public void should_not_save_the_author_and_publisher_before_book_when_are_pre_saved(){
    Integer id = 2;
    Author savedAuthor = make(a(Author, with(AuthorMaker.id, id)));
    Publisher savedPublisher = make(a(Publisher, with(PublisherMaker.id, id)));
    Book unsavedBook = make(a(Book, with(author, savedAuthor), with(publisher, savedPublisher)));

    when(authorService.findById(id)).thenReturn(savedAuthor);
    when(publisherService.findPublisherById(id)).thenReturn(savedPublisher);

    bookService.addBook(unsavedBook);

    verify(authorService, times(0)).saveAuthor(savedAuthor);
    verify(publisherService, times(0)).savePublisher(savedPublisher);
    verify(bookRepository, times(1)).save(unsavedBook);
  }

}