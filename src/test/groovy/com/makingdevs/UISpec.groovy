package com.makingdevs

import geb.spock.GebSpec

class UISpec extends GebSpec {

  def "visit makingdevs"(){
    when:
      go "http://makingdevs.com"
    then:
      title.startsWith("MakingDevs")
  }
}
