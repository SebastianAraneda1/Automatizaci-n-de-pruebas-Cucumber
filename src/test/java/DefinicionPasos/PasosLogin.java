package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class PasosLogin {

    @When("puedo acceder al login {string}")
    public void puedo_acceder_al_login(String enlace) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enlace)));
        loginLink.click();
        System.out.println("Accediendo al enlace de login.");
    }

    @When("ingreso un email incorrecto en {string} con texto {string}")
    public void ingreso_un_email_incorrecto_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el email incorrecto: " + email);
    }

    @When("ingreso un email correcto en {string} con texto {string}")
    public void ingreso_un_email_correcto_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el email correcto: " + email);
    }

    @When("ingreso una clave correcta en {string} con texto {string}")
    public void ingreso_una_clave_correcta_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando la clave correcta.");
    }
    
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
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
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
