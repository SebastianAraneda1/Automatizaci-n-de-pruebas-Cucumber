Feature: Carrito de Compras

  Scenario: Ususario añade producto a carro de compra desde el catalogo
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    Then se abre un menú lateral mostrando el producto agregado en "//*[@id='cart-drawer']/div[1]"
    
  Scenario: Aumentar la cantidad del producto
   	Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al icono + en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[2]"
    Then se suma una cantidad al producto
    
  Scenario: Reducir la cantidad del producto
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al icono + en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[2]"
    And le doy al icono - en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[1]"
    Then se resta una cantidad al producto
    
 Scenario: Validar que los productos puedan ser eliminados correctamente del carrito de compras.
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al icono de la basura en el producto "//*[@id='cart-item-1']/td[3]/div[1]/a"
    Then se elimina el producto y se vacía el menú mostrando Tu carrito esta vacío en "//*[@id='cart-items']/div[1]/p"
    
	Scenario: Validar que el precio aumente cuando se aumenten los productos
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al icono + en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[2]"
    Then se suma una cantidad al producto y el precio aumenta "//*[@id='cart-summary']/div[2]/p"
    
	Scenario: Validar que el precio se reduzca cuando se reduzca la cantidad de los productos
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al icono + en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[2]"
    And le doy al icono - en el producto "//*[@id='cart-item-1']/td[3]/div[1]/quantity-input/div/button[1]"
    Then se resta una cantidad al producto y el precio disminuye "//*[@id='cart-summary']/div[2]/p"
    
  Scenario: Validar que el usuario pueda regresar al catálogo desde el carrito de compras
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
   	And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al texto enlace Seguir comprando "//*[@id='cart-summary']/a"
    Then me redirecciona al catálogo "https://juegosenroque.cl/collections/todos-los-productos"
    
  Scenario: Validar que aparezca una alerta si el usuario intenta finalizar la compra sin aceptar los términos y condiciones
    Given que puedo acceder a la aplicación "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When puedo acceder al catalogo en "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/main-menu/details/div/nav[1]/ul/li[1]/details/summary/a"
    And clickeo el boton Agregar al carrito en un producto "//*[@id='quick-add-6991491170377']/button"
    And que pude añadir un producto al carrito de compras y voy al enlace del carrito "https://juegosenroque.cl/cart"
    And le doy al botón Finalizar compra sin marcar el check "//*[@id='cart-summary']/div[3]/button"
    Then aparecerá un alert indicando que lo debo marcar