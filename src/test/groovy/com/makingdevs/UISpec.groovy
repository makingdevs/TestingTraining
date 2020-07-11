package com.makingdevs

import geb.spock.GebReportingSpec

class UISpec extends GebReportingSpec {

  def "visit makingdevs"(){
    when:
      go "http://makingdevs.com"
    then:
      title ==~ /.*MakingDevs.*/
  }
}
