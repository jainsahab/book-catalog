package com.prateekj.services;

import com.prateekj.models.Author;
import com.prateekj.models.Book;
import com.prateekj.models.Publisher;
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
    Publisher foundPublisher = publisherService.findPublisherById(book.getPublisher().getId());
    if(foundPublisher == null)
      publisherService.savePublisher(book.getPublisher());
  }

  private void saveAuthorIfNot(Book book) {
    Author foundAuthor = authorService.findById(book.getAuthor().getId());
    if(foundAuthor == null)
      authorService.saveAuthor(book.getAuthor());
  }
}
