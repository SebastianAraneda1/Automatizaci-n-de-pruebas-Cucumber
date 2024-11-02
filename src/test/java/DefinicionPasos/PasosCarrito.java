package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PasosCarrito {

    private WebDriver driver = PasosComunes.driver;

    // Paso para acceder al catálogo
    @When("puedo acceder al catalogo en {string}")
    public void puedo_acceder_al_catalogo_en(String catalogXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement catalogLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(catalogXpath)));
        catalogLink.click();
        System.out.println("Accediendo al catálogo.");
    }

    // Paso para hacer clic en el botón "Agregar al carrito" en un producto
    @When("clickeo el boton Agregar al carrito en un producto {string}")
    public void clickeo_el_boton_agregar_al_carrito_en_un_producto(String botonXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(botonXpath)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        try {
            addToCartButton.click();
            System.out.println("Clickeando en el botón 'Agregar al carrito' en el producto.");
        } catch (Exception e) {
            System.out.println("Elemento no clickeable directamente, intentando con JavaScript.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }

        WebElement cartDrawer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-drawer']/div[1]")));
        assertTrue("El menú lateral no se muestra correctamente después de agregar el producto", cartDrawer.isDisplayed());
    }

    // Paso para ir al enlace del carrito después de añadir un producto
    @When("que pude añadir un producto al carrito de compras y voy al enlace del carrito {string}")
    public void que_pude_añadir_un_producto_al_carrito_y_voy_al_enlace_del_carrito(String carritoUrl) {
        driver.get(carritoUrl);
        System.out.println("Accediendo al enlace del carrito: " + carritoUrl);
    }

    // Paso para incrementar la cantidad del producto usando el botón "+"
    @When("le doy al icono + en el producto {string}")
    public void le_doy_al_icono_mas_en_el_producto(String botonMasXpath) {
        WebElement botonMas = retryingElementFind(By.xpath(botonMasXpath));
        retryingElementClick(botonMas);
        System.out.println("Incrementando la cantidad del producto en el carrito.");
    }

    // Paso para reducir la cantidad del producto usando el botón "-"
    @When("le doy al icono - en el producto {string}")
    public void le_doy_al_icono_menos_en_el_producto(String botonMenosXpath) {
        WebElement botonMenos = retryingElementFind(By.xpath(botonMenosXpath));
        retryingElementClick(botonMenos);
        System.out.println("Reduciendo la cantidad del producto en el carrito.");
    }

    // Paso para eliminar un producto del carrito
    @When("le doy al icono de la basura en el producto {string}")
    public void le_doy_al_icono_de_la_basura_en_el_producto(String botonEliminarXpath) {
        WebElement botonEliminar = retryingElementFind(By.xpath(botonEliminarXpath));
        retryingElementClick(botonEliminar);
        System.out.println("Eliminando el producto del carrito.");
    }

    // Paso para hacer clic en el enlace "Seguir comprando" en el carrito
    @When("le doy al texto enlace Seguir comprando {string}")
    public void le_doy_al_texto_enlace_seguir_comprando(String seguirComprandoXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement seguirComprandoEnlace = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(seguirComprandoXpath)));
        seguirComprandoEnlace.click();
        System.out.println("Haciendo clic en el enlace 'Seguir comprando'.");
    }

    // Paso para marcar el checkbox de términos y condiciones
    @When("le doy al check de términos y condiciones {string}")
    public void le_doy_al_check_de_terminos_y_condiciones(String checkXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkTerminos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkXpath)));
        checkTerminos.click();
        System.out.println("Marcando el check de términos y condiciones.");
    }

    // Paso para hacer clic en el botón "Finalizar compra" sin aceptar los términos
    @When("le doy al botón Finalizar compra sin marcar el check {string}")
    public void le_doy_al_boton_finalizar_compra_sin_marcar_el_check(String finalizarCompraXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finalizarCompraButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(finalizarCompraXpath)));
        finalizarCompraButton.click();
        System.out.println("Intentando finalizar compra sin marcar el check de términos y condiciones.");
    }

    // Paso para hacer clic en el botón "Finalizar Compra" después de marcar el check
    @When("le doy al botón Finalizar Compra {string}")
    public void le_doy_al_boton_finalizar_compra(String finalizarCompraXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finalizarCompraButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(finalizarCompraXpath)));
        finalizarCompraButton.click();
        System.out.println("Haciendo clic en el botón 'Finalizar Compra'.");
    }

    // Paso para verificar que el menú lateral se abre mostrando el producto agregado
    @Then("se abre un menú lateral mostrando el producto agregado en {string}")
    public void se_abre_un_menú_lateral_mostrando_el_producto_agregado_en(String menuLateralXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuLateral = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuLateralXpath)));
        assertTrue("El menú lateral no se muestra correctamente", menuLateral.isDisplayed());
        System.out.println("El menú lateral se abrió mostrando el producto agregado.");
    }

    // Paso para verificar que el usuario es redirigido al catálogo
    @Then("me redirecciona al catálogo {string}")
    public void me_redirecciona_al_catalogo(String catalogoUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(catalogoUrl));
        assertEquals("La URL actual no es la esperada para el catálogo.", catalogoUrl, driver.getCurrentUrl());
        System.out.println("El usuario fue redirigido correctamente al catálogo: " + catalogoUrl);
    }

    // Paso para verificar que aparece un alerta al intentar finalizar compra sin aceptar términos
    @Then("aparecerá un alert indicando que lo debo marcar")
    public void aparecera_un_alert_indicando_que_lo_debo_marcar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alerta encontrada indicando que se deben aceptar los términos y condiciones.");
            driver.switchTo().alert().accept(); // Cierra el alerta para seguir con las pruebas
        } catch (TimeoutException e) {
            System.out.println("No se encontró la alerta indicando que se deben aceptar los términos y condiciones.");
            assertTrue("No se mostró la alerta indicando que se debe marcar el checkbox.", false);
        }
    }

    // Paso para verificar que el usuario es redirigido al área de pago
    @Then("me redirecciona al area de pagar {string}")
    public void me_redirecciona_al_area_de_pagar(String paginaPagoUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(paginaPagoUrl));
        assertEquals("La URL actual no es la esperada para el área de pago.", paginaPagoUrl, driver.getCurrentUrl());
        System.out.println("El usuario fue redirigido correctamente al área de pago: " + paginaPagoUrl);
    }

    // Métodos auxiliares para manejo de elementos obsoletos y reintentos
    private WebElement retryingElementFind(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        int attempts = 0;
        while (attempts < 3) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (StaleElementReferenceException e) {
                System.out.println("Elemento obsoleto, reintentando localización... Intento: " + (attempts + 1));
                attempts++;
            }
        }
        throw new StaleElementReferenceException("No se pudo encontrar el elemento después de múltiples intentos: " + locator);
    }

    private void retryingElementClick(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Elemento obsoleto, reintentando clic... Intento: " + (attempts + 1));
                attempts++;
            }
        }
    }
}
