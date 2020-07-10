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
      input                     || _result
      ""                        || 0
      "4"                       || 4
      "4,5"                     || 9
      "8,5"                     || 13
      "4,5,6"                   || 15
      "1,2,3,4,5,5,6,7,8,9"     || 50
      "4,5\n6"                  || 15
      "1\n2,3,4,5\n5,6\n7,8,9"  || 50
      //"//;\n4;5;6"              || 15
      //"//|\n10|11|12|15"        || 48
  }
}
