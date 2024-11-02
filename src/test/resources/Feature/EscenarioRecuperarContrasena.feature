Feature: Recuperar Contraseña

Scenario: Ingresar correo electrónico existente en el sistema
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl/account"
    When hago click en el campo del correo "//*[@id='customer-email']"
    And relleno el campo con un correo existente en el sistema "usuario_pruebas18@outlook.es"
    Then me redirigirá al login "https://www.juegosenroque.cl/login"

