Feature: CheckOut

  Scenario: Ir a Pagar ahora  completando todos los campos obligatorios correctamente excepto la comuna de datos clientes, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']" "usuario_pruebas18@outlook.es"
    And ingreso un nombre "//*[@id='TextField14']" "Benito"
    And ingreso un apellido "//*[@id='TextField15']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField16']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField19']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField20']" "123456789"
    And selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    And ingreso un nombre "//*[@id='TextField35']" "Benito"
    And ingreso un apellido "//*[@id='TextField36']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField37']" "el chavo del 8"
    And ingreso una comuna inexistente "//*[@id='TextField40']" "Gotika"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me dará un error en comuna "//*[@id='error-for-TextField12']"



