package com.makingdevs

import spock.lang.*

class FullSpec extends Specification {

  @Unroll
  def "mostrar el ciclo de ejecución de Spock"() {
    given: "Dado un elemento de inicio"
    // setup: "Inicializa los reecursos para la especificación"
      println "Inicializando..."
      String s = a
    and: "Más elementos de inicio"
      println "Inicializando algo más..."
    when: "Ejecutas alguna acción"
      s = s.toUpperCase()
    and: "Y posiblemente otra acción"
      int size = s.size()
    then: "Esperas un resultado"
      size == result
      s == b
    cleanup: "Limpias y reinicias los recursos"
      println "limpiando..."
    where: "Aplica para los casos que tu describas"
    a       | b       | result
    "hola"  | "HOLA"  | 4
    "mundo" | "MUNDO" | 6
    "foo"   | "FOO"   | 3
  }
}

