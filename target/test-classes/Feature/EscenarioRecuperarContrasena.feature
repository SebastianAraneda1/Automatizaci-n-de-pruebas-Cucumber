Feature: Recuperar Contraseña

Scenario: Ingresar correo electrónico existente en el sistema
    Given que voy a recuperar contraseña "https://juegosenroque.cl/account/login#recover"
    When hago click en el campo del correo "//*[@id='recover-email']"
    And relleno el campo con un correo existente en el sistema "//*[@id='recover-email']"  "usuario_pruebas18@outlook.es"
    And hago click en restablecer "//*[@id='recover']/form/div[2]/button"
    Then me redirigirá al login "https://juegosenroque.cl/account/login"

Scenario: Ingresar correo electrónico no existente en el sistema
    Given que voy a recuperar contraseña "https://juegosenroque.cl/account/login#recover"
    When hago click en el campo del correo "//*[@id='recover-email']"
    And relleno el campo con un correo no existente en el sistema "//*[@id='recover-email']" "usuario_pruebas20@outlook.es"
    Then hago click en restablecer "//*[@id='recover']/form/div[2]/button"
    

Scenario: Ingresar un correo electrónico no válido (sin el @)
    Given que voy a recuperar contraseña "https://juegosenroque.cl/account/login#recover"
    When hago click en el campo del correo "//*[@id='recover-email']"
    And relleno el campo con un correo sin @ "//*[@id='recover-email']" "usuario_pruebas18outlook.es"
    Then hago click en restablecer "//*[@id='recover']/form/div[2]/button"
