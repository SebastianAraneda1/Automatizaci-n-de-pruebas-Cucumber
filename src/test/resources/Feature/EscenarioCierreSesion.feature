Feature: Cierre de Sesion

Scenario: Cerrar sesión con usuario ingresado
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl/account"
    When ingreso un email correcto en "//*[@id='customer-email']" con texto "usuario_pruebas18@outlook.es"
    And ingreso una clave correcta en "//*[@id='customer-password']" con texto "Testing123456."
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    And se clickea el botón Cerrar sesión en "//*[@id="main-content"]/div[1]/div/a[2]"
    Then lleva a la página de inicio "https://www.juegosenroque.cl"