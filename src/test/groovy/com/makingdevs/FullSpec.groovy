package com.makingdevs

import spock.lang.*

class FullSpec extends Specification {

  @Unroll("cuando #cadena se convierte a mayusculas es #cadena_mayus y tiene longitud #tamanio")
  def "mostrar el ciclo de ejecución de Spock"() {
    given: "Dado un elemento de inicio"
    // setup: "Inicializa los reecursos para la especificación"
      println "Inicializando..."
      String s = cadena
    and: "Más elementos de inicio"
      println "Inicializando algo más..."
    when: "Ejecutas alguna acción"
      s = s.toUpperCase()
    and: "Y posiblemente otra acción"
      int size = s.size()
    then: "Esperas un resultado"
      size == tamanio
      s == cadena_mayus
    cleanup: "Limpias y reinicias los recursos"
      println "limpiando..."
    where: "Aplica para los casos que tu describas"
    cadena  | cadena_mayus       | tamanio
    "hola"  | "HOLA"             | 4
    "mundo" | "MUNDO"            | 5
    "foo"   | "FOO"              | 3
  }
}

