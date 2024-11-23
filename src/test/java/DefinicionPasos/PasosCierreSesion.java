package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class PasosCierreSesion {

    private WebDriver driver = PasosComunes.driver;

    @When("puedo acceder al historial de pedidos {string}")
    public void puedo_acceder_al_historial_de_pedidos(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement historialPedidos = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        historialPedidos.click();
    }

    @When("se clickea el botón Cerrar sesión en {string}")
    public void se_clickea_el_boton_cerrar_sesion_en(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botonCerrarSesion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(botonCerrarSesion));
        botonCerrarSesion.click();
    }

 // Método para verificar la redirección a la página de inicio
    @Then("lleva a la pagina de inicio {string}")
    public void lleva_a_la_pagina_de_inicio(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try {
            System.out.println("Esperando redirección. URL actual antes de la espera: " + driver.getCurrentUrl());
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe(string),
                ExpectedConditions.urlToBe("https://juegosenroque.cl/challenge")
            ));
            
            String actualUrl = driver.getCurrentUrl();
            assertTrue("La URL actual no es la esperada. URL actual: " + actualUrl,
                       actualUrl.equals(string) || actualUrl.equals("https://juegosenroque.cl/challenge"));
            
            System.out.println("Redirigido correctamente a la página de inicio: " + string);
        } catch (Exception e) {
            System.out.println("Error de redirección. La URL actual es: " + driver.getCurrentUrl());
            throw e;
        }
    }

}
