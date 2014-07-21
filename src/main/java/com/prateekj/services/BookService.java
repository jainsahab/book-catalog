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
    findAuthorAndAssignToBook(book);
    findPublisherAndAssignToBook(book);
    bookRepository.save(book);
  }

  private void findPublisherAndAssignToBook(Book book) {
    Integer publisherId = book.getPublisher().getId();
    Publisher savedPublisher = publisherService.findPublisherById(publisherId);
    book.setPublisher(savedPublisher);
  }

  private void findAuthorAndAssignToBook(Book book) {
    Integer authorId = book.getAuthor().getId();
    Author savedUser = authorService.findById(authorId);
    book.setAuthor(savedUser);
  }
}
