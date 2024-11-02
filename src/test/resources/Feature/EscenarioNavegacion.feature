Feature: Navegacion del catalogo

  Scenario: Mostrar solo los productos agotados en el catálogo
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When selecciono el filtro Agotado "//*[@id='facets']/div/details-disclosure[2]/details/div/div/div[1]/ul/li[2]/label"
    Then me mostrará los productos que estan agotados "//*[@id='filter-results']/ul/li[1]/product-card/div[1]/div/div/span"
    
  Scenario: Desactivar el filtro de disponibilidad Agotado
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When selecciono el filtro Agotado "//*[@id='facets']/div/details-disclosure[2]/details/div/div/div[1]/ul/li[2]/label"
    And lo deselecciono "//*[@id='facets']/details-disclosure/details/div/div/div/a"
    Then se desactiva el filtro mostrandome el catalogo de forma normal "//*[@id='quick-add-6991491170377']/button/span[2]"
    
  Scenario: Activar el filtro de marca Devir
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When selecciono el filtro de marca Devir "//*[@id='facets']/div/details-disclosure[5]/details/div/div/div[1]/ul/li[4]/label"
    Then mostrará solo productos de la marca Devir "//*[@id='filter-results']/ul/li"
    
  Scenario: Desactivar el filtro de marca Devir
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When selecciono el filtro de marca Devir "//*[@id='facets']/div/details-disclosure[5]/details/div/div/div[1]/ul/li[4]/label"
    And lo desactivo "//*[@id='facets']/details-disclosure/details/div/div/div/a"
    Then se desactiva el filtro mostrandome el catalogo de forma normal "//*[@id='quick-add-6991491170377']/button/span[2]"
    
	Scenario: Ingresar un rango de precio
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When ingreso un precio inicial "//*[@id='price-range-number-min']" con valor "10000"
    And ingreso un precio final "//*[@id='price-range-number-max']" con valor "50000"
    Then mostrará solo productos entre ese rango de precio "//*[@id='filter-results']/ul/li"
    
  Scenario: Desactivar filtro de rango de precio
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When ingreso un precio inicial "//*[@id='price-range-number-min']" con valor "10000"
    And ingreso un precio final "//*[@id='price-range-number-max']" con valor "50000"
    And desactivo el filtro "//*[@id='facets']/details-disclosure/details/div/div/div/a"
    Then se desactiva el filtro mostrandome el catalogo de forma normal "//*[@id='quick-add-6991491170377']/button/span[2]"
    
  Scenario: Activar filtro de tiempo de juego
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When activo el filtro de tiempo de juego menor a 30 min "//*[@id='facets']/div/details-disclosure[6]/details/div/div/div[1]/ul/li[1]/label"
    Then mostrará solo productos menor a esa duracion "//*[@id='filter-results']/ul/li"
    
  Scenario: Desactivar filtro de mecánica Colaborativo
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When activo el filtro de mecanica Colaborativo "//*[@id='facets']/div/details-disclosure[8]/details/div/div/div[1]/ul/li[2]/label"
    And lo desactivo "//*[@id='facets']/details-disclosure/details/div/div/div/a"
    Then se desactiva el filtro mostrandome el catalogo de forma normal "//*[@id='quick-add-6991491170377']/button/span[2]"
    
  Scenario: Buscar un juego 5 Minutes Dungeon
    Given que estoy en el catalogo de juegos de mesa "https://juegosenroque.cl/collections/todos-los-juegos-de-mesa"
    When me dirijo a la barra de busqueda "//*[@id='header-search']"
    And busco 5 Minutes Dungeon "//*[@id='header-search']" y presiono el boton buscar "//*[@id='shopify-section-sections--15864809029705__header']/store-header/header/div[2]/predictive-search/form/search-form/button[1]"
    Then mostrará el juego 5 Minutes Dungeon "//*[@id='filter-results']/ul/li[1]/product-card"