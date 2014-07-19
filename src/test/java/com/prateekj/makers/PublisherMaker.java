package com.prateekj.makers;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.prateekj.models.Publisher;

public class PublisherMaker {
  public static final Property<Publisher, Integer> id = new Property<Publisher, Integer>();
  public static final Property<Publisher, String> name = new Property<Publisher, String>();

  public static final Instantiator<Publisher> Publisher = new Instantiator<Publisher>() {
    public Publisher instantiate(PropertyLookup<Publisher> lookup) {
      Publisher author = new Publisher();
      author.setId(lookup.valueOf(id, (Integer) null));
      author.setName(lookup.valueOf(name, "some-name"));
      return author;
    }
  };


}
