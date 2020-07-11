package com.makingdevs

import spock.lang.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import javax.sql.DataSource

@SpringBootTest
class TestingTrainingApplicationIntegrationSpec extends Specification {

  @Autowired
  ApplicationContext applicationContext

  @Autowired
  DataSource dataSource

  def "when startup the application context is up"() {
    expect:
      applicationContext
      dataSource
  }

}

