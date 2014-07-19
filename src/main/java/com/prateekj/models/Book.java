package com.prateekj.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

  @Id
  @GeneratedValue(strategy = AUTO)
  @Column(name = "id")
  Integer id;

  @Column(name = "title")
  String title;

  @OneToOne
  @JoinColumn(name = "author_id")
  Author author;

  @OneToOne
  @JoinColumn(name = "publisher_id")
  Publisher publisher;
}
