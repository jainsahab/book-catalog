package com.prateekj.services;

import com.prateekj.models.Book;
import com.prateekj.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private AuthorService authorService;

  @Autowired
  private PublisherService publisherService;

  @Autowired
  private BookRepository bookRepository;

  public void addBook(Book book) {
    saveAuthorIfNot(book);
    savePublisherIfNot(book);
    bookRepository.save(book);
  }

  private void savePublisherIfNot(Book book) {
    Integer publisherId = book.getPublisher().getId();
    if(publisherId == null)
      publisherService.savePublisher(book.getPublisher());
  }

  private void saveAuthorIfNot(Book book) {
    Integer authorId = book.getAuthor().getId();
    if(authorId == null)
      authorService.saveAuthor(book.getAuthor());
  }
}
