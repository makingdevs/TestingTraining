package com.makingdevs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class StringCalculatorData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String input;
  private int result;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getInput() {
    return this.input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public int getResult() {
    return this.result;
  }

  public void setResult(int result) {
    this.result = result;
  }

}
