package com.prateekj.services;

import com.prateekj.makers.PublisherMaker;
import com.prateekj.models.Publisher;
import com.prateekj.repositories.PublisherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.natpryce.makeiteasy.MakeItEasy.a;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.prateekj.makers.PublisherMaker.Publisher;
import static com.prateekj.makers.PublisherMaker.id;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
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

  @Test
  public void shouldGetAllThePublishers(){
    Publisher publisher1 = make(a(PublisherMaker.Publisher));
    Publisher publisher2 = make(a(PublisherMaker.Publisher));

    when(publisherRepository.findAll()).thenReturn(asList(publisher1, publisher2));

    List<Publisher> publishers = publisherService.getAllPublisher();

    assertThat(publishers, hasSize(2));
    assertThat(publishers, hasItems(publisher1, publisher2));
  }

}