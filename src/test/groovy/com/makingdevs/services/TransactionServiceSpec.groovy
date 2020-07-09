package com.makingdevs.services

import spock.lang.*
import com.makingdevs.model.Transaction

class TransactionServiceSpec extends Specification {

  def "Cuenta los registros para una tabla no esperada"(){
    given:
      TransactionService service = new TransactionService()
      String tableName = null
    when:
      service.countRecordsFor(tableName)
    then:
      thrown RuntimeException
  }

  def "Busca los registros para una tabla no esperada"(){
    given:
      TransactionService service = new TransactionService()
      String tableName = null
    when:
      service.findAll(tableName)
    then:
      RuntimeException ex = thrown()
      ex.message == "Cannot find !!!"
  }

  def "Altera una tabla que no existe"(){
    given:
      TransactionService service = new TransactionService()
      String tableName = null
    when:
      service.updateTable(tableName)
    then:
      notThrown(NullPointerException)
      //thrown NullPointerException
  }

  def "do a payment with a quantity"() {
    given:
      TransactionService service = new TransactionService()
    and: "Valid trx"
       def trx = new Transaction()
       trx.status = "DO"
    and:
      PaymentGateway paymentGatewayMock = Mock()
      service.paymentGateway = paymentGatewayMock
      TransactionBuilder transactionBuilderMock = Stub()
      transactionBuilderMock.buildWithAmount(_) >> trx
      service.transactionBuilder = transactionBuilderMock
    and:
      def amount = 100.00
    when:
      int result = service.doPayment(amount)
    then:
      1 * paymentGatewayMock.authorize(_)
  }

  def "don't do a payment with a negative quantity"() {
    given:
      TransactionService service = new TransactionService()
    and: "Valid trx"
       def trx = new Transaction()
       trx.status = "DONT"
    and:
      PaymentGateway paymentGatewayMock = Mock()
      service.paymentGateway = paymentGatewayMock
      TransactionBuilder transactionBuilderMock = Stub()
      transactionBuilderMock.buildWithAmount(_) >> trx
      service.transactionBuilder = transactionBuilderMock
    and:
      def amount = -1_332_323.00
    when:
      int result = service.doPayment(amount)
    then:
      0 * paymentGatewayMock.authorize(_)
  }

  def "do many payments with many quantities"() {
    given:
      TransactionService service = new TransactionService()
    and: "Valid trx"
       def trx = new Transaction()
       trx.status = "DO"
    and:
      PaymentGateway paymentGatewayMock = Mock()
      service.paymentGateway = paymentGatewayMock
      TransactionBuilder transactionBuilderMock = Stub()
      transactionBuilderMock.buildWithAmount(_) >> trx
      service.transactionBuilder = transactionBuilderMock
    and:
      def amounts = [100.0,200.0,300.0]
    when:
      def results = service.doManyPayments(amounts)
    then:
      3 * paymentGatewayMock.authorize(_)
  }

  def "do a payment with a quantity and it's OK"() {
    given:
      TransactionService service = new TransactionService()
    and: "Valid trx"
       def trx = new Transaction()
       trx.status = "DO"
    and:
      PaymentGateway paymentGatewayMock = Stub()
      paymentGatewayMock.authorize(_) >> true
      service.paymentGateway = paymentGatewayMock
      TransactionBuilder transactionBuilderMock = Stub()
      transactionBuilderMock.buildWithAmount(_) >> trx
      service.transactionBuilder = transactionBuilderMock
    and:
      def amount = 100
    when:
      int result = service.doPayment(amount)
    then:
      result == 304
  }

  @Unroll("For the amounts #_amounts the trx status are #_results")
  def "do many payments with many quantities and it's OK"() {
    given:
      TransactionService service = new TransactionService()
    and:
      PaymentGateway paymentGatewayMock = Mock()
      service.paymentGateway = paymentGatewayMock
      TransactionBuilder transactionBuilderMock = Mock()
      service.transactionBuilder = transactionBuilderMock
    and:
      def amounts = _amounts
    when:
      def results = service.doManyPayments(amounts)
    then:
      results == _results
      payGwTouches * paymentGatewayMock.authorize(_) >>> pyGwResponses
      trxBdrTouches * transactionBuilderMock.buildWithAmount(_) >>> trxBldrResponses
    where:
      _amounts          || _results         |  payGwTouches | pyGwResponses | trxBdrTouches | trxBldrResponses
      [1.0,2.0,3.0]     || [304, 0, 304]    | 2             | [true, true]  | 3             | [validTrx(), invalidTrx(), validTrx()]
      [1.0,2.0,3.0,4.0] || [304, 0, 304, 0] | 2             | [true, true]  | 4             | [validTrx(), invalidTrx(), validTrx(), invalidTrx()]
      [-1.0]            || [0]              | 1             | [false]       | 1             | [validTrx()]
      [-1.0]            || [0]              | 0             | [false]       | 1             | [invalidTrx()]
  }

  private def validTrx(){ new Transaction(status: "DO") }
  private def invalidTrx(){ new Transaction(status: "DONT") }
}
