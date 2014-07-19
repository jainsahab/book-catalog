package com.prateekj.repositories;

import com.prateekj.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer>{
}
