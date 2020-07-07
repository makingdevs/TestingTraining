package com.makingdevs

import spock.lang.*

class FirstSpec extends Specification {

  def "Foo first specification"(){
    expect:
      1 == 1
  }

  def "Agregar un nuevo objeto a un Set"(){
    given:
      def bag = [2,3,4,5] as Set
    when:
      bag << 1
    then:
      bag.size() == 5
  }
}
