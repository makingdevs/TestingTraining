package com.makingdevs

import spock.lang.*

class FullSpec extends Specification {

  def "mostrar el ciclo de ejecución de Spock"() {
    given: "Dado un elemento de inicio"
    // setup: "Inicializa los reecursos para la especificación"
      println "Inicializando..."
      String s = "Hola mundo"
    and: "Más elementos de inicio"
      println "Inicializando algo más..."
    when: "Ejecutas alguna acción"
      s = s.toUpperCase()
    and: "Y posiblemente otra acción"
      int size = s.size()
    then: "Esperas un resultado"
      size == 10
      s == "HOLA MUNDO"
    cleanup: "Limpias y reinicias los recursos"
      println "limpiando..."
    //where: "Aplica para los casos que tu describas"
  }
}

