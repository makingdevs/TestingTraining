package com.makingdevs.model;

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
public class StringCalulatorData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String input;
  private int result;



}
