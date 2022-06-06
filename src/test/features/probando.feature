Feature: Visualizar posts
  Scenario: El usuario quiere visualizar una determinada publicación
    When llama el endpoint posts indicando su id
    Then el codigo de respuesta es de 200
    And muestra la descripcion correcta