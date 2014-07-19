package com.prateekj.repositories;

import com.prateekj.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
}
