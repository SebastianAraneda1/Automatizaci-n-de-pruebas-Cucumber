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

    // ACCEDER AL ENLACE
    @Given("que estoy en el catalogo de juegos de mesa {string}")
    public void que_estoy_en_el_catalogo_de_juegos_de_mesa(String catalogoUrl) throws InterruptedException {
        driver.get(catalogoUrl);
        Thread.sleep(3000);
    }

    // HACER CLICK EN FILTRO AGOTADO
    @When("selecciono el filtro Agotado {string}")
    public void selecciono_el_filtro_agotado(String filtroAgotadoXpath) throws InterruptedException {
        driver.findElement(By.xpath(filtroAgotadoXpath)).click();
        Thread.sleep(2500);
    }

    // DESELECCIONAR FILTRO AGOTADO
    @When("lo deselecciono {string}")
    public void lo_deselecciono(String desactivacionFiltroXpath) {
        driver.findElement(By.xpath(desactivacionFiltroXpath)).click();
    }
    
    // VERIFICACION SOLO PRODUCTOS AGOTADOS
    @Then("me mostrará los productos que estan agotados {string}")
    public void me_mostrara_los_productos_que_estan_agotados(String productoAgotadoXpath) {
        verifyElementsVisibility(productoAgotadoXpath, "Producto agotado visible en el catálogo.");
    }

    // SELECCIONAR FILTRO DEVIR
    @When("selecciono el filtro de marca Devir {string}")
    public void selecciono_el_filtro_de_marca_devir(String filtroMarcaDevirXpath) {
        driver.findElement(By.xpath(filtroMarcaDevirXpath)).click();
    }

    // DESELECCIONAR FILTRO DEVIR
    @When("lo desactivo devir {string}")
    public void lo_desactivo_devir(String desactivacionFiltroMarcaDevirXpath) {
        driver.findElement(By.xpath(desactivacionFiltroMarcaDevirXpath)).click();
    }
    
    // VERIFICAR SOLO MARCA DEVIR
    @Then("mostrará solo productos de la marca Devir {string}")
    public void mostrara_solo_productos_de_la_marca_devir(String productoMarcaDevirXpath) {
        verifyElementsVisibility(productoMarcaDevirXpath, "Producto de la marca 'Devir' visible en el catálogo.");
    }
    
    // PRECIO INICIAL
    @When("ingreso un precio inicial {string} con valor {string}")
    public void ingreso_un_precio_inicial(String campoPrecioMinXpath, String valorMin) throws InterruptedException {
    	driver.findElement(By.xpath(campoPrecioMinXpath)).click();
    	driver.findElement(By.xpath(campoPrecioMinXpath)).clear();
    	driver.findElement(By.xpath(campoPrecioMinXpath)).sendKeys(valorMin);
    	Thread.sleep(1500);
    }

    // PRECIO FINAL
    @When("ingreso un precio final {string} con valor {string}")
    public void ingreso_un_precio_final(String campoPrecioMaxXpath, String valorMax) throws InterruptedException {
    	driver.findElement(By.xpath(campoPrecioMaxXpath)).click();
    	driver.findElement(By.xpath(campoPrecioMaxXpath)).clear();
    	driver.findElement(By.xpath(campoPrecioMaxXpath)).sendKeys(valorMax);
    	Thread.sleep(2500);
    }
    
    // DESACTIVAR FILTRO PRECIO
    @Then("desactivo el filtro {string}")
    public void desactivo_el_filtro(String desactivacionPrecio) throws InterruptedException {
    	driver.findElement(By.xpath(desactivacionPrecio)).click();
    	Thread.sleep(2500);
    }

    // ACTIVAR FILTRO COLABORATIVO
    @When("activo el filtro de mecanica Colaborativo {string}")
    public void activo_el_filtro_de_mecanica_colaborativo(String filtroColaborativoXpath) {
        driver.findElement(By.xpath(filtroColaborativoXpath)).click();
    }
    
    // DESACTIVAR FILTRO COLABORATIVO
    @When("lo desactivo colab {string}")
    public void lo_desactivo_colab(String desactivarFiltroColab) {
        driver.findElement(By.xpath(desactivarFiltroColab)).click();
    }

    
    // VERIFICAR FILTRO COLABORATIVO
    @Then("mostrará solo productos de juego colaborativos {string}")
    public void mostrara_solo_productos_de_juego_colaborativos(String productoColaborativoXpath) throws InterruptedException {
        verifyElementsVisibility(productoColaborativoXpath, "Producto de mecánica 'Colaborativo' visible en el catálogo.");
    	Thread.sleep(2500);
    }
    
    // ACTIVAR FILTRO MENOR A 30 MINUTOS
    @When("activo el filtro de tiempo de juego menor a 30 min {string}")
    public void activo_el_filtro_de_tiempo_de_juego_menor_a_30_min(String filtroTiempoJuegoXpath) {
        driver.findElement(By.xpath(filtroTiempoJuegoXpath)).click();
    }

    // IR A BARRA DE BUSQUEDA
    @When("me dirijo a la barra de busqueda {string}")
    public void me_dirijo_a_la_barra_de_busqueda(String barraBusquedaXpath) {
        driver.findElement(By.xpath(barraBusquedaXpath)).click();
    }

    // BUSCAR EN BARRA DE BUSQUEDA
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
