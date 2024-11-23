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

public class PasosRecuperarContrasena {
    
    private WebDriver driver = PasosComunes.driver;

    @Given("que voy a recuperar contraseña {string}")
    public void que_voy_a_recuperar_contrasena(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
    }

    @When("hago click en el campo del correo {string}")
    public void hago_click_en_el_campo_del_correo(String correoXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(correoXpath)));
        emailField.click();
        System.out.println("Haciendo click en el campo del correo.");
    }

    @When("relleno el campo con un correo existente en el sistema {string}")
    public void relleno_el_campo_con_un_correo_existente_en_el_sistema(String correo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recover-email']")));
        emailField.clear();
        emailField.sendKeys(correo);
        System.out.println("Rellenando el campo con un correo existente en el sistema: " + correo);
    }

    @Then("me redirigirá al login {string}")
    public void me_redirigira_al_login(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Aumentar tiempo de espera
        wait.until(ExpectedConditions.urlContains(expectedUrl.split("#")[0])); // Verifica si contiene la parte base de la URL
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl.split("#")[0], actualUrl.split("#")[0]); // Compara solo la parte base de las URLs
        System.out.println("Redirigido correctamente al login.");
    }

    @When("relleno el campo con un correo no existente en el sistema {string}")
    public void relleno_el_campo_con_un_correo_no_existente_en_el_sistema(String correo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recover-email']")));
        emailField.clear();
        emailField.sendKeys(correo);
        System.out.println("Rellenando el campo con un correo no existente en el sistema: " + correo);
    }

    @Then("me aparecerá el mensaje: {string} {string}")
    public void me_aparecera_el_mensaje(String mensaje, String mensajeXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mensajeXpath)));
        String actualMessage = messageElement.getText();
        assertEquals(mensaje, actualMessage);
        System.out.println("Mensaje de error visible: " + actualMessage);
    }

    @When("relleno el campo con un correo sin {string}")
    public void relleno_el_campo_con_un_correo_sin(String correo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recover-email']")));
        emailField.clear();
        emailField.sendKeys(correo);
        System.out.println("Rellenando el campo con un correo sin '@': " + correo);
    }

    @Then("me validará el campo")
    public void me_validara_el_campo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Aumentar tiempo de espera
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='recover-email-error']")));
        assertTrue("Campo email no válido", errorElement.isDisplayed());
        System.out.println("Validación del campo email completada.");
    }

    @When("relleno el campo con un correo existente en el sistema {string}  {string}")
    public void relleno_el_campo_con_un_correo_existente_en_el_sistema(String string, String string2) throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath(string));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(string2);
        Thread.sleep(2500);
    }

    @When("relleno el campo con un correo no existente en el sistema {string} {string}")
    public void relleno_el_campo_con_un_correo_no_existente_en_el_sistema_con_xpath(String campoCorreoXpath, String correo) throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath(campoCorreoXpath));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(correo);
        Thread.sleep(2500);
    }

    @When("relleno el campo con un correo sin @ {string} {string}")
    public void relleno_el_campo_con_un_correo_sin_xpath(String campoCorreoXpath, String correo) throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath(campoCorreoXpath));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(correo);
        Thread.sleep(2500);
    }

    @Then("hago click en restablecer {string}")
    public void hago_click_en_restablecer(String botonRestablecerXpath) throws InterruptedException {
        WebElement botonRestablecer = driver.findElement(By.xpath(botonRestablecerXpath));
        botonRestablecer.click();
        Thread.sleep(2500);
    }
}
