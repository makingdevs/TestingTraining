package com.makingdevs

import spock.lang.*

class StringCalculatorSpec extends Specification {

  @Unroll("The String Calculator for #input is #_result")
  def "do a string calculator"() {
    given:
      def sc = new StringCalculator()
    when:
      def result = sc.add(input)
    then:
      result == _result
   where:
      input << [
          "","4","4,5","8,5",
          "4,5,6","1,2,3,4,5,5,6,7,8,9",
          "4,5\n6","1\n2,3,4,5\n5,6\n7,8,9"]
      _result << [0, 4, 9, 13, 15, 50, 15, 50 ]
  }

}
