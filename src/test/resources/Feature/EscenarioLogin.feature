Feature: Autenticacion de usuarios

  Scenario: Login con datos correctos
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl"
    When puedo acceder al login "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/div[3]/a[1]"
    And ingreso un email correcto en "//*[@id='customer-email']" con texto "usuario_pruebas18@outlook.es"
    And ingreso una clave correcta en "//*[@id='customer-password']" con texto "Testing123456."
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    Then redirige a un captcha "https://juegosenroque.cl/challenge"

  Scenario: Login con datos vacios
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl"
    When puedo acceder al login "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/div[3]/a[1]"
    And no ingreso email "//*[@id='customer-email']" con texto ""
    And no ingreso una clave "//*[@id='customer-password']" con texto ""
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    Then redirige a un captcha "https://juegosenroque.cl/challenge"

  Scenario: Login con correo correcto y password incorrecto
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl"
    When puedo acceder al login "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/div[3]/a[1]"
    And ingreso un email correcto en "//*[@id='customer-email']" con texto "usuario_pruebas18@outlook.es"
    And ingreso una clave incorrecta en "//*[@id='customer-password']" con texto "T123456"
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    Then redirige a un captcha "https://juegosenroque.cl/challenge"

  Scenario: Login con correo incorrecto y password incorrecto
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl"
    When puedo acceder al login "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/div[3]/a[1]"
    And ingreso un email incorrecto en "//*[@id='customer-email']" con texto "usuarwqwqrwrrwr242@outlook.es"
    And ingreso una clave incorrecta en "//*[@id='customer-password']" con texto "T123456"
    And realizo el envío de los datos apretando el botón "//*[@id='customer_login']/div[3]/button"
    Then redirige a un captcha "https://juegosenroque.cl/challenge"