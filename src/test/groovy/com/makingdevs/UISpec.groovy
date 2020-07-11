package com.makingdevs

import geb.spock.GebReportingSpec
import spock.lang.*

class UISpec extends GebReportingSpec {

  @Unroll
  def "visit makingdevs"(){
    when:
      go "http://makingdevs.com"
    and:
      $("#top-navigation > ul > div > a.top-create-account").click()

      $("form input[name=nombre]") << nombre
      $("form input[name=apellidoPaterno]") << apellidoPaterno
      $("form input[name=apellidoMaterno]") << apellidoMaterno

      $("body > section > div > div > div.span9 > div > form > fieldset > div:nth-child(6) > div > div > button").click()
    and:
      def errorMessages = $("body > section > div > div > div.span9 > div > form > fieldset > div:nth-child(1) > div > div").text()
    then:
      title ==~ /.*SignUp.*/
      errorMessages.contains("no puede")
    where:
      nombre    | apellidoPaterno   | apellidoMaterno
      "juan"    | "Reyes"           | "Zuñiga"
      "angel"   | "contreras"       | "torres"
      "gibran"  | "bernal"          | "reyes"

  }
}
