Feature: Checkout

Scenario: Ir a "Pagar ahora" sin completar ningún campo
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When hago click en el botón "Pagar ahora" "//*[@id='checkout-pay-button']" sin rellenar campos
    Then me validarán los campos correo, nombre y apellido, dirección, comuna y teléfono

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me redireccionará a "https://www.flow.cl/app/web/pay.php?token=A5C408FC351ED913943BAB3D6211E21022633EDF"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto el correo, colocando uno que no exista
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email no existente "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me validará el campo email "//*[@id='error-for-email']"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto la dirección, colocando una dirección inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección inexistente "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me validará el campo dirección "//*[@id='error-for-TextField2']"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto la comuna, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna inexistente "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me validará el campo comuna "//*[@id='Form1']/div[1]/div[3]/div/section/div/div[2]/section[2]/div/div/div[2]/div/div"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto el teléfono, colocando un teléfono inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono inexistente "//*[@id='TextField20']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me validará el campo teléfono "//*[@id='error-for-TextField6']"

 Scenario: Cambiar tipo de entrega
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When selecciono tipo de entrega "retiro a domicilio" "//*[@id='delivery_strategies']/div/div[2]/div/div[1]"
    Then me aparecerán las sucursales de retiro disponibles "//*[@id='local_pickup_methods']/div/div/div/div[1]"

Scenario: Cambiar tipo de pago
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When selecciono tipo de pago "Transferencia o depósito bancario" "//*[@id='basic-manualPayment-72169652297']"
    Then me aparecerá un mensaje con instrucciones "//*[@id='basic-manualPayment-72169652297-collapsible']/div/div"

Scenario: Cambiar datos del cliente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    Then me aparecerá un formulario "//*[@id='billing_address_selector-custom_billing_address-collapsible']/div/div"

Scenario: Ir a "Pagar ahora" sin completar ningún campo del datos cliente en "Usar datos distintos a los del envío"
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me validarán los campos; nombre y apellido, dirección y comuna
 
 Scenario: Ir a "Pagar ahora" completando los campos del datos cliente en "Usar datos distintos a los del envío"
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    And ingreso un nombre "//*[@id='TextField35']"
    And ingreso un apellido "//*[@id='TextField36']"
    And ingreso una dirección "//*[@id='TextField37']"
    And ingreso una comuna "//*[@id='TextField40']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me redireccionará a flow "https://www.flow.cl/app/web/pay.php?token=A5C408FC351ED913943BAB3D6211E21022633EDF"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto la dirección de datos clientes, colocando una dirección inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    And ingreso un nombre "//*[@id='TextField35']"
    And ingreso un apellido "//*[@id='TextField36']"
    And ingreso una dirección inexistente "//*[@id='TextField37']"
    And ingreso una comuna "//*[@id='TextField40']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me dará un error en dirección "//*[@id='error-for-TextField9']"

Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente excepto la comuna de datos clientes, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And selecciono en datos cliente "Usar datos distintos a los del envío" "//*[@id='billing_address_selector-custom_billing_address']"
    And ingreso un nombre "//*[@id='TextField35']"
    And ingreso un apellido "//*[@id='TextField36']"
    And ingreso una dirección "//*[@id='TextField37']"
    And ingreso una comuna inexistente "//*[@id='TextField40']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me dará un error en comuna "//*[@id='error-for-TextField12']"
 
 Scenario: Ir a "Pagar ahora" completando todos los campos obligatorios correctamente, sin los datos del cliente pero con el tipo de pago por transferencia
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When ingreso un email "//*[@id='email']"
    And ingreso un nombre "//*[@id='TextField14']"
    And ingreso un apellido "//*[@id='TextField15']"
    And ingreso una dirección "//*[@id='TextField16']"
    And ingreso una comuna "//*[@id='TextField19']"
    And ingreso un teléfono "//*[@id='TextField20']"
    And selecciono tipo de pago "Transferencia o depósito bancario" "//*[@id='basic-manualPayment-72169652297']"
    And hago click en el botón pagar "//*[@id='checkout-pay-button']"
    Then me redireccionará a pantalla de pago "¡Gracias por tu compra! - Juegos Enroque - Pantalla de pago"
 