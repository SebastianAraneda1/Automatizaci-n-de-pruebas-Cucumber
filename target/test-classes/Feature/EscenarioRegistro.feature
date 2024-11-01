Feature: Registro de nuevos usuarios

  Scenario: Registro de usuario con datos correctos
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then redirige a la página de inicio "https://juegosenroque.cl/"
