package com.makingdevs.services;

import com.makingdevs.model.Transaction;
import java.math.BigDecimal;

public interface TransactionBuilder {

  Transaction  buildWithAmount(BigDecimal amount);
}

