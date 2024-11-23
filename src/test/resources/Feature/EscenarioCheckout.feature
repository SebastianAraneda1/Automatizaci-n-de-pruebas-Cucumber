Feature: CheckOut

 Scenario: Ir a Pagar ahora sin completar ningún campo
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    Then hago click en el botón Pagar ahora sin rellenar campos "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And ingreso un email "//*[@id='email']" "usuario_pruebas18@outlook.es"
    And ingreso un nombre "//*[@id='TextField0']" "Benito"
    And ingreso un apellido "//*[@id='TextField1']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField2']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField5']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora  completando todos los campos obligatorios correctamente excepto la comuna de datos clientes, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
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

	Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente excepto la comuna, colocando una comuna inexistente
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And ingreso un email "//*[@id='email']" "usuario_pruebas18@outlook.es"
    And ingreso un nombre "//*[@id='TextField14']" "Benito"
    And ingreso un apellido "//*[@id='TextField15']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField16']" "el chavo del 8"
    And ingreso una comuna inexistente "//*[@id='TextField19']" "Cucumelo"
    And ingreso un teléfono "//*[@id='TextField20']" "123456789"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
	

