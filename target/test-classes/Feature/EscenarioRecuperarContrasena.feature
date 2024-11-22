Feature: Recuperar Contraseña

Scenario: Ingresar correo electrónico existente en el sistema
    Given que puedo acceder a la aplicación "https://www.juegosenroque.cl/account"
    When hago click en el campo del correo "//*[@id='customer-email']"
    And relleno el campo con un correo existente en el sistema "usuario_pruebas18@outlook.es"
    Then me redirigirá al login "https://www.juegosenroque.cl/login"

Scenario: Ingresar un correo electrónico no existente en el sistema 
		Given que voy a recuperar contraseña "https://www.juegosenroque.cl/account" 
		When hago click en el campo del correo "//*[@id='customer-email']" 
		And relleno el campo con un correo no existente en el sistema "correo_no_existente@ejemplo.com" 
		Then me aparecerá el mensaje: "No se encontró ninguna cuenta con esta dirección de correo electrónico."

Scenario: Ingresar un correo electrónico no valido (sin el @) 
		Given que voy a recuperar contraseña "https://www.juegosenroque.cl/account" 
		When hago click en el campo del correo "//*[@id='customer-email']" 
		And relleno el campo con un correo sin @ "correoinvalido.com" 
		Then me validará el campo lo mismo y me mostrará el mensaje: