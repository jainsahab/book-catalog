package com.prateekj.services;

import com.prateekj.models.Publisher;
import com.prateekj.repositories.PublisherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.PublisherMaker.Publisher;
import static com.prateekj.makers.PublisherMaker.id;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PublisherServiceTest {

  @InjectMocks
  private PublisherService publisherService;

  @Mock
  private PublisherRepository publisherRepository;

  @Test
  public void shouldSaveTheUser(){
    int publisherId = 1;
    Publisher aPublisher = make(a(Publisher, with(id, publisherId)));

    publisherService.savePublisher(aPublisher);

    verify(publisherRepository, times(1)).save(aPublisher);
  }

  @Test
  public void shouldFindTheUserById(){
    int publisherId = 1;
    Publisher savedPublisher = make(a(Publisher, with(id, publisherId)));

    when(publisherRepository.findOne(savedPublisher.getId())).thenReturn(savedPublisher);

    Publisher foundPublisher = publisherService.findPublisherById(savedPublisher.getId());

    assertThat(foundPublisher, is(savedPublisher));
    verify(publisherRepository, times(1)).findOne(savedPublisher.getId());
  }

}