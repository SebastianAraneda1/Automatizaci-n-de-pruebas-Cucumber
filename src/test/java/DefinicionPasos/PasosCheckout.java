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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PasosCheckout {
    
    private WebDriver driver = PasosComunes.driver;

    @Given("que pude añadir un producto al carrito de compras y voy al enlace del checkout {string}")
    public void que_pude_añadir_un_producto_al_carrito_de_compras_y_voy_al_enlace_del_checkout(String url) {
        driver.get(url);
    }

    @When("ingreso un email {string} {string}")
    public void ingreso_un_email(String xpath, String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(1500);
    }

    @When("ingreso un nombre {string} {string}")
    public void ingreso_un_nombre(String xpath, String nombre) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nombreField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        nombreField.click();
        nombreField.clear();
        nombreField.sendKeys(nombre);
        Thread.sleep(1500);
    }
    
    @When("ingreso un apellido {string} {string}")
    public void ingreso_un_apellido(String xpath, String apellido) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement apellidoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        apellidoField.click();
        apellidoField.clear();
        apellidoField.sendKeys(apellido);
        Thread.sleep(1500);
    }

    @When("ingreso una dirección {string} {string}")
    public void ingreso_una_direccion(String xpath, String direccion) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement direccionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        direccionField.click();
        direccionField.clear();
        direccionField.sendKeys(direccion);
        Thread.sleep(1500);
    }

    @When("ingreso una comuna {string} {string}")
    public void ingreso_una_comuna(String xpath, String comuna) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement comunaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        comunaField.click();
        comunaField.clear();
        comunaField.sendKeys(comuna);
        Thread.sleep(1500);
    }
    
    @When("ingreso una comuna inexistente {string} {string}")
    public void ingreso_una_comuna_inexistente(String xpath, String comunaInexistente) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement comunaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        comunaField.click();
        comunaField.clear();
        comunaField.sendKeys(comunaInexistente);
        Thread.sleep(1500);
    }

    @When("ingreso un teléfono {string} {string}")
    public void ingreso_un_telefono(String xpath, String telefono) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement telefonoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        telefonoField.click();
        telefonoField.clear();
        telefonoField.sendKeys(telefono);
        Thread.sleep(1500);
    }
    
    @When("selecciono en datos cliente {string}")
    public void selecciono_en_datos_cliente(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement datosClienteField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        datosClienteField.click();
        System.out.println("Seleccionando 'Usar datos distintos a los del envío'.");
    }

    @When("hago click en el botón pagar {string}")
    public void hago_click_en_el_boton_pagar(String botonPagarXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pagarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(botonPagarXpath)));
        pagarButton.click();
        System.out.println("Haciendo click en el botón pagar.");
    }

    @Then("me dará un error en comuna {string}")
    public void me_dara_un_error_en_comuna(String mensajeErrorXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mensajeErrorXpath)));
        assertTrue("Error en comuna no visible", errorElement.isDisplayed());
        System.out.println("Error en comuna visible.");
    }

    @When("selecciono tipo de pago {string}")
    public void selecciono_tipo_de_pago(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement tipoPagoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        tipoPagoField.click();
        System.out.println("Seleccionando tipo de pago.");
    }

    @Then("me redireccionará a pantalla de pago {string}")
    public void me_redireccionara_a_pantalla_de_pago(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente a la pantalla de pago.");
    }
}
