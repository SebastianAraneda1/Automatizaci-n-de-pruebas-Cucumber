Feature: CheckOut



 Scenario: Ir a Pagar ahora sin completar ningún campo
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSkJQQ1MxVjg5NjJYSjIxN1M2MzBWUUNQ" 
    Then hago click en el botón Pagar ahora sin rellenar campos "//*[@id=checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSkJQQ1MxVjg5NjJYSjIxN1M2MzBWUUNQ"
    And ingreso un email "//*[@id='email']" "usuario_pruebas18@outlook.es"
    And ingreso un nombre "//*[@id='TextField0']" "Benito"
    And ingreso un apellido "//*[@id='TextField1']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField2']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField5']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me redireccionará a flow "https://www.flow.cl/app/web/pay.php?token=C975096B3A47DFC8B9F18D3A9BD0E2BB95"
















  Scenario: Ir a Pagar ahora  completando todos los campos obligatorios correctamente excepto la comuna de datos clientes, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSkJQQ1MxVjg5NjJYSjIxN1M2MzBWUUNQ"
    And ingreso un email "//*[@id='email']" "usuario_pruebas18@outlook.es"
    And ingreso un nombre "//*[@id='TextField0']" "Benito"
    And ingreso un apellido "//*[@id='TextField1']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField2']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField5']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
    And selecciono en datos cliente Usar datos distintos a los del envío "//*[@id='billing_address_selector-custom_billing_address']"
    And ingreso un nombre "//*[@id='TextField7']" "Benito"
    And ingreso un apellido "//*[@id='TextField8']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField9']" "el chavo del 8"
    And ingreso una comuna inexistente "//*[@id='TextField12']" "Gotika"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"



