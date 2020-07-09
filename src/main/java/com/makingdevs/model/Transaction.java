package com.makingdevs.model;

import java.math.BigDecimal;

public class Transaction {
  private BigDecimal amount;
  private String status;

  public void setAmount(BigDecimal amount){
    this.amount = amount;
  }

  public BigDecimal getAmount(){
    return this.amount;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public String getStatus(){
    return this.status;
  }
}
