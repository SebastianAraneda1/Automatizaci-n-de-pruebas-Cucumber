Feature: Registro de nuevos usuarios

  Scenario: Registro de usuario con datos correctos
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then redirige a la página de inicio "https://juegosenroque.cl/"
    
  Scenario: Registro de usuario con datos vacíos
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When no ingreso un nombre en "//*[@id='register-first-name']" con texto ""
    And no ingreso un apellido en "//*[@id='register-last-name']" con texto ""
    And no ingreso un correo electrónico en "//*[@id='register-email']" con texto ""
    And no ingreso una contraseña en "//*[@id='register-password']" con texto ""
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario sin ingresar Nombre y Apellido
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When no ingreso un nombre en "//*[@id='register-first-name']" con texto ""
    And no ingreso un apellido en "//*[@id='register-last-name']" con texto ""
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then redirige a la página de inicio "https://juegosenroque.cl/"
    
  Scenario: Registro de usuario sin ingresar Correo
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And no ingreso un correo electrónico en "//*[@id='register-email']" con texto ""
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario sin ingresar Contraseña
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And no ingreso un correo electrónico en "//*[@id='register-email']" con texto ""
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario con un correo existente
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario con un correo no válido
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico no válido en "//*[@id='register-email']" con texto "correo_invalido"
    And ingreso una contraseña válida en "//*[@id='register-password']" con texto "ContraseñaPrueba123"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario con una contraseña corta (4 caracteres o menos)
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña no válida en "//*[@id='register-password']" con texto "1234"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece mensaje de error en "/html/body/main/div/div/form/div[1]"
    
  Scenario: Registro de usuario con una contraseña corta (4 caracteres o menos)
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/account/register"
    When ingreso un nombre en "//*[@id='register-first-name']" con texto "NombrePrueba"
    And ingreso un apellido en "//*[@id='register-last-name']" con texto "ApellidoPrueba"
    And ingreso un correo electrónico válido en "//*[@id='register-email']" con texto "usuario_prueba@outlook.com"
    And ingreso una contraseña no válida en "//*[@id='register-password']" con texto "1234"
    And realizo el envío de los datos apretando el botón "//*[@id='create_customer']/div[5]/button"
    Then aparece un error en "/html/body/main/div/div/form/div[1]"
    
    