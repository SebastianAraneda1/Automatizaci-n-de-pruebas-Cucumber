package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PasosRegistro {
    
    private WebDriver driver = PasosComunes.driver;

    // Método para ingresar un nombre
    @When("ingreso un nombre en {string} con texto {string}")
    public void ingreso_un_nombre_en_con_texto(String nombreXpath, String nombre) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nombreField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nombreXpath)));
        nombreField.click();
        nombreField.clear();
        nombreField.sendKeys(nombre);
        System.out.println("Ingresando el nombre: " + nombre);
    }

    // Método para ingresar un apellido
    @When("ingreso un apellido en {string} con texto {string}")
    public void ingreso_un_apellido_en_con_texto(String apellidoXpath, String apellido) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement apellidoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apellidoXpath)));
        apellidoField.click();
        apellidoField.clear();
        apellidoField.sendKeys(apellido);
        System.out.println("Ingresando el apellido: " + apellido);
    }

    // Método para ingresar un correo electrónico válido
    @When("ingreso un correo electrónico válido en {string} con texto {string}")
    public void ingreso_un_correo_electronico_valido_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el correo electrónico válido: " + email);
    }

    // Método para ingresar un correo electrónico no válido
    @When("ingreso un correo electrónico no válido en {string} con texto {string}")
    public void ingreso_un_correo_electronico_no_valido_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando un correo electrónico no válido: " + email);
    }

    // Método para ingresar una contraseña válida
    @When("ingreso una contraseña válida en {string} con texto {string}")
    public void ingreso_una_contrasena_valida_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando una contraseña válida.");
    }

    // Método para ingresar una contraseña no válida (corta)
    @When("ingreso una contraseña no válida en {string} con texto {string}")
    public void ingreso_una_contrasena_no_valida_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando una contraseña no válida (corta): " + password);
    }

    // Método para no ingresar un nombre (dejar el campo vacío)
    @When("no ingreso un nombre en {string} con texto {string}")
    public void no_ingreso_un_nombre_en_con_texto(String nombreXpath, String nombre) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nombreField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nombreXpath)));
        nombreField.clear();
        System.out.println("No ingresando el nombre, campo vaciado.");
    }

    // Método para no ingresar un apellido (dejar el campo vacío)
    @When("no ingreso un apellido en {string} con texto {string}")
    public void no_ingreso_un_apellido_en_con_texto(String apellidoXpath, String apellido) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement apellidoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apellidoXpath)));
        apellidoField.clear();
        System.out.println("No ingresando el apellido, campo vaciado.");
    }

    // Método para no ingresar un correo electrónico (dejar el campo vacío)
    @When("no ingreso un correo electrónico en {string} con texto {string}")
    public void no_ingreso_un_correo_electronico_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.clear();
        System.out.println("No ingresando el correo electrónico, campo vaciado.");
    }

    // Método para no ingresar una contraseña (dejar el campo vacío)
    @When("no ingreso una contraseña en {string} con texto {string}")
    public void no_ingreso_una_contrasena_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        System.out.println("No ingresando la contraseña, campo vaciado.");
    }

    // Método para verificar que el mensaje de error aparece sin verificar el texto específico
    @Then("aparece mensaje de error en {string}")
    public void aparece_mensaje_de_error_en(String errorXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorXpath)));
        
        // Verifica que el mensaje de error esté visible
        assertTrue("El mensaje de error no es visible", errorMessage.isDisplayed());
        System.out.println("Mensaje de error visible en el registro.");
    }

    // Método alternativo para verificar la presencia de cualquier error genérico
    @Then("aparece un error en {string}")
    public void aparece_un_error_en(String errorXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorXpath)));
        
        // Verifica que el mensaje de error esté visible
        assertTrue("El mensaje de error no es visible", errorMessage.isDisplayed());
        System.out.println("Mensaje de error genérico visible en el registro.");
    }

    // Método para verificar la redirección a la página de inicio
    @Then("redirige a la página de inicio {string}")
    public void redirige_a_la_pagina_de_inicio(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe(expectedUrl),
                ExpectedConditions.urlToBe("https://juegosenroque.cl/challenge")
            ));
            
            String actualUrl = driver.getCurrentUrl();
            assertTrue("La URL actual no es la esperada. URL actual: " + actualUrl,
                       actualUrl.equals(expectedUrl) || actualUrl.equals("https://juegosenroque.cl/challenge"));
            
            System.out.println("Redirigido correctamente a la página de inicio o a la página de desafío.");
        } catch (Exception e) {
            System.out.println("Error de redirección. La URL actual es: " + driver.getCurrentUrl());
            throw e;
        }
    }
}
