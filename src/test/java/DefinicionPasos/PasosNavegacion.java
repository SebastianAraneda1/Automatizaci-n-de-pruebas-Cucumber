package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PasosNavegacion {

    private WebDriver driver = PasosComunes.driver;

    // Paso para acceder al catálogo de juegos de mesa
    @Given("que estoy en el catalogo de juegos de mesa {string}")
    public void que_estoy_en_el_catalogo_de_juegos_de_mesa(String catalogoUrl) {
        driver.get(catalogoUrl);
        System.out.println("Accediendo al catálogo de juegos de mesa: " + catalogoUrl);
    }

    // Paso para seleccionar el filtro "Agotado"
    @When("selecciono el filtro Agotado {string}")
    public void selecciono_el_filtro_agotado(String filtroAgotadoXpath) {
        clickElement(filtroAgotadoXpath, "Seleccionando el filtro 'Agotado'.");
    }

    // Paso para deseleccionar el filtro "Agotado"
    @When("lo deselecciono {string}")
    public void lo_deselecciono(String desactivacionFiltroXpath) {
        clickElement(desactivacionFiltroXpath, "Desactivando el filtro 'Agotado'.");
    }

    // Paso para seleccionar el filtro de marca "Devir"
    @When("selecciono el filtro de marca Devir {string}")
    public void selecciono_el_filtro_de_marca_devir(String filtroMarcaDevirXpath) {
        clickElement(filtroMarcaDevirXpath, "Seleccionando el filtro de marca 'Devir'.");
    }

    // Paso para deseleccionar el filtro de marca "Devir"
    @When("lo desactivo {string}")
    public void lo_desactivo(String desactivacionFiltroMarcaDevirXpath) {
        clickElement(desactivacionFiltroMarcaDevirXpath, "Desactivando el filtro de marca 'Devir'.");
    }

    // Paso para activar el filtro de mecánica "Colaborativo"
    @When("activo el filtro de mecanica Colaborativo {string}")
    public void activo_el_filtro_de_mecanica_colaborativo(String filtroColaborativoXpath) {
        clickElement(filtroColaborativoXpath, "Activando el filtro de mecánica 'Colaborativo'.");
    }

    // Paso para activar el filtro de tiempo de juego menor a 30 minutos
    @When("activo el filtro de tiempo de juego menor a 30 min {string}")
    public void activo_el_filtro_de_tiempo_de_juego_menor_a_30_min(String filtroTiempoJuegoXpath) {
        clickElement(filtroTiempoJuegoXpath, "Activando el filtro de tiempo de juego menor a 30 minutos.");
    }

    // Paso para ingresar el precio inicial en el rango de precios
    @When("ingreso un precio inicial {string} con valor {string}")
    public void ingreso_un_precio_inicial(String campoPrecioMinXpath, String valorMin) {
        enterText(campoPrecioMinXpath, valorMin, "Ingresando precio mínimo: " + valorMin);
    }

    // Paso para ingresar el precio final en el rango de precios
    @When("ingreso un precio final {string} con valor {string}")
    public void ingreso_un_precio_final(String campoPrecioMaxXpath, String valorMax) {
        enterText(campoPrecioMaxXpath, valorMax, "Ingresando precio máximo: " + valorMax);
    }

    // Paso para buscar "5 Minutes Dungeon" en la barra de búsqueda
    @When("me dirijo a la barra de busqueda {string}")
    public void me_dirijo_a_la_barra_de_busqueda(String barraBusquedaXpath) {
        clickElement(barraBusquedaXpath, "Dirigiéndose a la barra de búsqueda.");
    }

    @When("busco 5 Minutes Dungeon {string} y presiono el boton buscar {string}")
    public void busco_5_minutes_dungeon_y_presiono_el_boton_buscar(String barraBusquedaXpath, String botonBuscarXpath) {
        enterText(barraBusquedaXpath, "5 Minutes Dungeon", "Buscando el juego '5 Minutes Dungeon'.");
        clickElement(botonBuscarXpath, "Presionando el botón de búsqueda.");
    }

    // Paso para verificar que el filtro ha sido desactivado y se muestran todos los productos
    @Then("se desactiva el filtro mostrandome el catalogo de forma normal {string}")
    public void se_desactiva_el_filtro_mostrandome_el_catalogo_de_forma_normal(String productoNormalXpath) {
        verifyElementsVisibility(productoNormalXpath, "El filtro se ha desactivado y el catálogo se muestra de forma normal.");
    }

    // Paso para verificar que se muestran solo productos de la marca "Devir"
    @Then("mostrará solo productos de la marca Devir {string}")
    public void mostrara_solo_productos_de_la_marca_devir(String productoMarcaDevirXpath) {
        verifyElementsVisibility(productoMarcaDevirXpath, "Producto de la marca 'Devir' visible en el catálogo.");
    }

    // Paso para verificar que se muestran solo productos agotados
    @Then("me mostrará los productos que estan agotados {string}")
    public void me_mostrara_los_productos_que_estan_agotados(String productoAgotadoXpath) {
        verifyElementsVisibility(productoAgotadoXpath, "Producto agotado visible en el catálogo.");
    }

    // Paso para verificar que se muestran solo productos colaborativos
    @Then("mostrará solo productos de juego colaborativos {string}")
    public void mostrara_solo_productos_de_juego_colaborativos(String productoColaborativoXpath) {
        verifyElementsVisibility(productoColaborativoXpath, "Producto de mecánica 'Colaborativo' visible en el catálogo.");
    }

    // Paso para verificar que se muestran solo productos con tiempo de juego menor a 30 minutos
    @Then("mostrará solo productos menor a esa duracion {string}")
    public void mostrara_solo_productos_menor_a_esa_duracion(String productoDuracionXpath) {
        verifyElementsVisibility(productoDuracionXpath, "Producto con tiempo de juego menor a 30 minutos visible en el catálogo.");
    }

    // Paso para verificar que el juego "5 Minutes Dungeon" aparece en los resultados de búsqueda
    @Then("mostrará el juego 5 Minutes Dungeon {string}")
    public void mostrara_el_juego_5_minutes_dungeon(String juegoResultadoXpath) {
        verifyElementsVisibility(juegoResultadoXpath, "El juego '5 Minutes Dungeon' está visible en los resultados de búsqueda.");
    }

    // Helper method to click an element
    private void clickElement(String xpath, String actionDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
            System.out.println(actionDescription);
        } catch (Exception e) {
            System.out.println("Error al intentar realizar la acción: " + actionDescription + ". Error: " + e.getMessage());
            fail("No se pudo hacer clic en el elemento: " + actionDescription);
        }
    }

    // Helper method to enter text in a field
    private void enterText(String xpath, String text, String actionDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
            System.out.println(actionDescription);
        } catch (Exception e) {
            System.out.println("Error al intentar ingresar texto: " + actionDescription + ". Error: " + e.getMessage());
            fail("No se pudo ingresar texto en el elemento: " + actionDescription);
        }
    }

    // Helper method to verify visibility of elements
    private void verifyElementsVisibility(String xpath, String successMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            assertTrue("No se encontraron elementos visibles para la verificación.", elements.size() > 0);
            elements.forEach(element -> System.out.println(successMessage));
        } catch (Exception e) {
            System.out.println("Error al verificar la visibilidad de los elementos. Error: " + e.getMessage());
            fail("No se pudo verificar la visibilidad de los elementos.");
        }
    }
}
