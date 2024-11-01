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

public class PasosRegistro {
    
    private WebDriver driver = PasosComunes.driver;

    @When("ingreso un nombre en {string} con texto {string}")
    public void ingreso_un_nombre_en_con_texto(String nombreXpath, String nombre) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nombreField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nombreXpath)));
        nombreField.click();
        nombreField.clear();
        nombreField.sendKeys(nombre);
        System.out.println("Ingresando el nombre: " + nombre);
    }

    @When("ingreso un apellido en {string} con texto {string}")
    public void ingreso_un_apellido_en_con_texto(String apellidoXpath, String apellido) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement apellidoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apellidoXpath)));
        apellidoField.click();
        apellidoField.clear();
        apellidoField.sendKeys(apellido);
        System.out.println("Ingresando el apellido: " + apellido);
    }

    @When("ingreso un correo electrónico válido en {string} con texto {string}")
    public void ingreso_un_correo_electronico_valido_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el correo electrónico: " + email);
    }

    @When("ingreso una contraseña válida en {string} con texto {string}")
    public void ingreso_una_contrasena_valida_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando la contraseña.");
    }

    @Then("redirige a la página de inicio {string}")
    public void redirige_a_la_pagina_de_inicio(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente a la página de inicio.");
    }
}
