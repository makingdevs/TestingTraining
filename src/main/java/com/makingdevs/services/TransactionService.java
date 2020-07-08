package com.makingdevs.services;

import java.util.List;
import java.math.BigDecimal;

public class TransactionService {

  public int countRecordsFor(String table){
    if(table.equals("") || table == null)
      throw new RuntimeException("No hay tabla!!!!");
    return 0;
  }

  public List findAll(String table){
    throw new RuntimeException("Cannot find !!!");
  }

  public void updateTable(String table){
    //throw new UnsupportedOperationException();
  }

  public int doPayment(BigDecimal amount){
    return  0;
  }

}
