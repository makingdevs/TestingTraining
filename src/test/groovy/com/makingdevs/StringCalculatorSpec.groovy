package com.makingdevs

import spock.lang.*
import groovy.sql.*

class StringCalculatorSpec extends Specification {

  @Shared db = [
    url: 'jdbc:mysql://localhost/data_for_test',
    user: 'makingdevs',
    password: 'makingdevs'
  ]
  @Shared sql = Sql.newInstance(db)

  @Unroll("The String Calculator for #input is #_result")
  def "do a string calculator"() {
    given:
      def sc = new StringCalculator()
    when:
      def result = sc.add(input)
    then:
      result == _result
   where:
    [input, _result] << sql.rows("select input, result from string_calculator_data")
  }

}
