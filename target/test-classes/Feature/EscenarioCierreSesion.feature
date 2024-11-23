Feature: Cierre de Sesion

Scenario: Cerrar sesión con usuario ingresado
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl/account"
    When ingreso un email correcto en "//*[@id='customer-email']" con texto "usuario_pruebas18@outlook.es"
    And ingreso una clave correcta en "//*[@id='customer-password']" con texto "Testing123456."
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    Then lleva a la pagina de inicio "https://www.juegosenroque.cl"
