package com.prateekj.makers;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.prateekj.models.Author;

public class AuthorMaker {
  public static final Property<Author, Integer> id = new Property<Author, Integer>();
  public static final Property<Author, String> name = new Property<Author, String>();

  public static final Instantiator<Author> Author = new Instantiator<Author>() {
    public Author instantiate(PropertyLookup<Author> lookup) {
      Author author = new Author();
      author.setId(lookup.valueOf(id, (Integer) null));
      author.setName(lookup.valueOf(name, "some-name"));
      return author;
    }
  };


}
