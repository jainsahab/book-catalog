package com.prateekj.services;

import com.prateekj.models.Publisher;
import com.prateekj.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

  public List<Publisher> getAllPublisher() {
    ArrayList<Publisher> allPublishers = new ArrayList<Publisher>();
    for (Publisher publisher : publisherRepository.findAll()) {
      allPublishers.add(publisher);
    }
    return allPublishers;
  }
}
