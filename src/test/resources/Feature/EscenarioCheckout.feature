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
    
    
#--------------Revisar------------------------------------


  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente excepto el correo, colocando uno que no exista
    Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And ingreso un email inexistente "//*[@id='email']" "usuario_pruebas99@duocuc.cl"
    And ingreso un nombre "//*[@id='TextField0']" "Benito"
    And ingreso un apellido "//*[@id='TextField1']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField2']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField5']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente excepto la dirección, colocando una dirección inexistente
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
    And ingreso una dirección inexistente "//*[@id='TextField2']" "Narnia 19232"
    And ingreso una comuna "//*[@id='TextField5']" "Gotika"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
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
    And ingreso un nombre "//*[@id='TextField0']" "Benito"
    And ingreso un apellido "//*[@id='TextField1']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField2']" "el chavo del 8"
    And ingreso una comuna inexistente "//*[@id='TextField5']" "San Chicureo 2.0"
    And ingreso un teléfono "//*[@id='TextField6']" "123456789"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente excepto el teléfono, colocando un teléfono inexistente
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
    And ingreso un teléfono inexistente "//*[@id='TextField6']" "0000000"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
  
  Scenario: Cambiar tipo de entrega
  	Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And Seleccionar tipo de entrega retiro en tienda "//*[@id='delivery_strategies']/div/div[2]/div/div[2]/label/div/p"
    Then Me aparecerán las sucursales de retiro disponible "//*[@id='local_pickup_methods']/div/div/div/div[1]/div/address"
    
  Scenario: Cambiar tipo de pago
  	Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And Seleccionar tipo de pago Transferencia o deposito bancario "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]"
    Then Me aparecera un mensaje con instrucciones "//*[@id='basic-manualPayment-72169652297-collapsible']/div/div/div/p"
    
  Scenario: Cambiar datos del cliente
  	Given que pude añadir un producto al carrito de compras y voy al enlace del checkout "https://juegosenroque.cl/checkouts/cn/Z2NwLXVzLWVhc3QxOjAxSjlIUkQ3N1c0QUZBOTJCUVpGOUIyRVpX"
    When puedo acceder al catalogo enn "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un productoo "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carritoo "https://juegosenroque.cl/cart"
    And voy al carrito con producto "https://juegosenroque.cl/cart"
    And acepto terminos y condiciones "//*[@id='cart-summary']/cart-terms/label"
    And voy a finalizar compra "//*[@id='cart-summary']/div[3]/button"
    
    And Selecciono en datos cliente Usar datos distintos a los del envio "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/label"
    Then Me aparecerá un formulario "//*[@id='billing_address_selector-custom_billing_address-collapsible']/div/div" 
  
  Scenario: Ir a Pagar ahora sin completar ningún campo del datos cliente en Usar datos distintos a los del envio
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
    And Selecciono en datos cliente Usar datos distintos a los del envio "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/label"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando los campos del datos cliente en Usar datos distintos a los del envio
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
    And Selecciono en datos cliente Usar datos distintos a los del envio "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/label"
    And ingreso un nombre "//*[@id='TextField35']" "Benito"
    And ingreso un apellido "//*[@id='TextField36']" "Carmelo"
    And ingreso una dirección "//*[@id='TextField37']" "el chavo del 8"
    And ingreso una comuna "//*[@id='TextField40']" "Gotika"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente excepto la direccion de datos clientes, colocando una direccion inexistente
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
    And Selecciono en datos cliente Usar datos distintos a los del envio "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/label"
    And ingreso un nombre "//*[@id='TextField35']" "Benito"
    And ingreso un apellido "//*[@id='TextField36']" "Carmelo"
    And ingreso una dirección inexistente "//*[@id='TextField37']" "no existe jaja"
    And ingreso una comuna "//*[@id='TextField40']" "Gotika"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
      
  Scenario: Ir a Pagar ahora completando todos los campos obligatorios correctamente, sin los datos del cliente pero con el tipo de pago por transferencia
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
    And Selecciono tipo de pago Transferencia o deposito bancario "//*[@id='Form1']/div[1]/section[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/label/span"
    Then hago click en el botón pagar "//*[@id='checkout-pay-button']"
    
    
#--------------Revisar------------------------------------  


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
	

