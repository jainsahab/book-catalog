package com.prateekj.repositories;

import com.prateekj.models.Publisher;
import com.prateekj.setup.TestSetup;
import org.junit.Test;

import static com.prateekj.Utils.TestUtils.isNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PublisherRepositoryTest extends TestSetup{

  @Test
  public void shouldAddPublisher(){
    String ram = "ram books";
    Publisher publisher = new Publisher();
    publisher.setName(ram);

    Publisher savedPublisher = publisherRepository.save(publisher);

    assertThat(savedPublisher.getName(), is(publisher.getName()));
    assertTrue(isNotNull(savedPublisher.getId()));
  }

}