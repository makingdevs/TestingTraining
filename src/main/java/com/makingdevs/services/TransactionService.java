package com.makingdevs.services;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import com.makingdevs.model.Transaction;
import com.makingdevs.services.PaymentGateway;

public class TransactionService {

  private PaymentGateway paymentGateway;
  private TransactionBuilder transactionBuilder;

  public void setPaymentGateway(PaymentGateway pg){
    this.paymentGateway = pg;
  }

  public PaymentGateway getPaymentGateway(){
    return this.paymentGateway;
  }

  public void setTransactionBuilder(TransactionBuilder tb){
    this.transactionBuilder = tb;
  }

  public TransactionBuilder getTransactionBuilder(){
    return this.transactionBuilder;
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
    Transaction trx = transactionBuilder.buildWithAmount(amount);
    boolean passed = false;
    if(trx.getStatus().equals("DO"))
      passed = paymentGateway.authorize(trx);
    if(passed) return 304;
    return  0;
  }

  public List<Integer> doManyPayments(List<BigDecimal> amounts){
    List<Integer> results = new ArrayList<Integer>();
    for(BigDecimal amount : amounts) {
      int result = doPayment(amount);
      results.add(result);
    };
    return results;
  }

}
