package com.makingdevs.services;

import com.makingdevs.model.Transaction;

public interface PaymentGateway {

  boolean authorize(Transaction trx);
}
