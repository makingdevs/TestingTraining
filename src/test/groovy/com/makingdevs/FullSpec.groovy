package com.makingdevs

import spock.lang.*

class FullSpec extends Specification {

  def "mostrar el ciclo de ejecución de Spock"() {
    setup: "Inicializa los reecursos para la especificación"
    and: "Más elementos de inicio"
    given: "Dado un elemento de inicio"
    and: "Y algo más al inicio"
    when: "Ejecutas alguna acción"
    and: "Y posiblemente otra acción"
    expect: "Esperas un resultado"
    cleanup: "Limpias y reinicias los recursos"
    where: "Aplica para los casos que tu describas"
  }
}

