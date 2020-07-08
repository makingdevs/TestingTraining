package com.makingdevs.services;

import java.util.List;
import java.math.BigDecimal;
import com.makingdevs.model.Transaction;
import com.makingdevs.services.PaymentGateway;

public class TransactionService {

  private PaymentGateway paymentGateway;

  public void setPaymentGateway(PaymentGateway pg){
    this.paymentGateway = pg;
  }

  public PaymentGateway getPaymentGateway(){
    return this.paymentGateway;
  }

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

    Transaction trx = new Transaction();
    trx.setAmount(amount);
    boolean passed = paymentGateway.authorize(trx);
    if(passed) return 304;
    return  0;
  }

}
