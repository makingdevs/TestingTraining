package com.makingdevs.model;

import java.math.BigDecimal;

public class Transaction {
  private BigDecimal amount;

  public void setAmount(BigDecimal amount){
    this.amount = amount;
  }

  public BigDecimal getAmount(){
    return this.amount;
  }
}
