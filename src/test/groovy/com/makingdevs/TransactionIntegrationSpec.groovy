package com.makingdevs

import spock.lang.*
import org.springframework.transaction.annotation.Transactional
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Propagation
import com.makingdevs.repository.StringCalculatorRepository
import com.makingdevs.model.StringCalculatorData

@SpringBootTest
@Transactional
class TransactionIntegrationSpec extends Specification {

  @Autowired
  JpaTransactionManager jpaTransactionManager

  @Autowired
  StringCalculatorRepository repository

  //@Transactional(propagation = Propagation.REQUIRES_NEW)
  def "do a transaction"() {
    given:
      def transaction = jpaTransactionManager.getTransaction()
    when:
      println "*"*100
      println transaction.properties
      println "*"*100
    then:
      transaction
  }

  def "create a new string calculator data"() {
    given:
      def data = new StringCalculatorData(input:"", result: 0)
    when:
      def result = repository.save(data)
      def count = repository.count()
    then:
      result.id
      count
  }

}
