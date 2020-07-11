package com.makingdevs

import spock.lang.*
import org.springframework.transaction.annotation.Transactional
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
@Transactional
class TransactionIntegrationSpec extends Specification {

  @Autowired
  JpaTransactionManager jpaTransactionManager

  def "do a transaction"() {
    given:
      def transaction = jpaTransactionManager.doGetTransaction()
    when:
      println "*"*100
      println transaction.properties
      println "*"*100
    then:
      transaction
  }

}
