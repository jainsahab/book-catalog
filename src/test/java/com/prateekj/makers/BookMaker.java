package com.prateekj.makers;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.prateekj.models.Author;
import com.prateekj.models.Book;
import com.prateekj.models.Publisher;

public class BookMaker {
  public static final Property<Book, Integer> id = new Property<Book, Integer>();
  public static final Property<Book, String> title = new Property<Book, String>();
  public static final Property<Book, Author> author = new Property<Book, Author>();
  public static final Property<Book, Publisher> publisher = new Property<Book, Publisher>();

  public static final Instantiator<Book> Book = new Instantiator<Book>() {
    public Book instantiate(PropertyLookup<Book> lookup) {
      Book book = new Book();
      book.setId(lookup.valueOf(id, (Integer) null));
      book.setTitle(lookup.valueOf(title, "some-name"));
      book.setAuthor(lookup.valueOf(author, (Author) null));
      book.setPublisher(lookup.valueOf(publisher, (Publisher) null));
      return book;
    }
  };


}
