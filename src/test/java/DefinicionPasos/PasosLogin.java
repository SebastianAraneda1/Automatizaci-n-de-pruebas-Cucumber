package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class PasosLogin {
	
    private WebDriver driver = PasosComunes.driver;
    
	// ACCEDER AL LOGIN
    @When("puedo acceder al login {string}")
    public void puedo_acceder_al_login(String enlace) {
        driver.findElement(By.xpath(enlace)).click();
    }

    // INGRESO DE EMAIL CORRECTO
    @When("ingreso un email correcto en {string} con texto {string}")
    public void ingreso_un_email_correcto_en_con_texto(String emailXpath, String email) throws InterruptedException {
    	driver.findElement(By.xpath(emailXpath)).click();
    	driver.findElement(By.xpath(emailXpath)).clear();
    	driver.findElement(By.xpath(emailXpath)).sendKeys(email);
    	Thread.sleep(1500);
    }

    // INGRESO DE UNA CONTRASENA CORRECTA
    @When("ingreso una clave correcta en {string} con texto {string}")
    public void ingreso_una_clave_correcta_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    // EMAIL VACIO
    @When("no ingreso email {string} con texto {string}")
    public void no_ingreso_email_con_texto(String emailXpath, String email) {
    	driver.findElement(By.xpath(emailXpath)).click();
    	driver.findElement(By.xpath(emailXpath)).clear();
    	driver.findElement(By.xpath(emailXpath)).sendKeys(email);
    }

    // CLAVE VACIA
    @When("no ingreso una clave {string} con texto {string}")
    public void no_ingreso_una_clave_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // INGRESO DE EMAIL INCORRECTO
    @When("ingreso un email incorrecto en {string} con texto {string}")
    public void ingreso_un_email_incorrecto_en_con_texto(String emailXpath, String email) throws InterruptedException {
    	driver.findElement(By.xpath(emailXpath)).click();
    	driver.findElement(By.xpath(emailXpath)).clear();
    	driver.findElement(By.xpath(emailXpath)).sendKeys(email);
    	Thread.sleep(1500);
    }
    
    // INGRESO DE CLAVE INCORRECTA
    @When("ingreso una clave incorrecta en {string} con texto {string}")
    public void ingreso_una_clave_incorrecta_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando la clave incorrecta.");
    }

    @Then("redirige a un captcha {string}")
    public void redirige_a_un_captcha(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = PasosComunes.driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente al captcha.");
    }

    @Then("aparece mensaje Correo electrónico o contraseña incorrectos {string}")
    public void aparece_mensaje_error(String errorMessageXpath) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(20));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        String actualMessage = errorMessage.getText();
        assertEquals("Correo electrónico o contraseña incorrectos", actualMessage.trim());
        System.out.println("Mensaje de error visible: " + actualMessage);
    }
}
