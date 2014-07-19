package com.prateekj.services;

import com.prateekj.models.Publisher;
import com.prateekj.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
  @Autowired
  private PublisherRepository publisherRepository;

  public Publisher savePublisher(Publisher savedPublisher) {
    return publisherRepository.save(savedPublisher);
  }

  public Publisher findPublisherById(Integer id) {
    return publisherRepository.findOne(id);
  }
}
