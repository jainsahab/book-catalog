package com.prateekj.services;

import com.prateekj.models.Author;
import com.prateekj.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public Author saveAuthor(Author author){
    return authorRepository.save(author);
  }

  public Author findById(Integer id) {
    return authorRepository.findOne(id);
  }
}
