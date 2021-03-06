package com.prateekj.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@EqualsAndHashCode
public class Publisher {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = AUTO)
  Integer id;

  @Column(name = "name")
  String name;

}
