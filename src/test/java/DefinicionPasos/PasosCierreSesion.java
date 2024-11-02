package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

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

    @Then("lleva a la página de inicio {string}")
    public void lleva_a_la_pagina_de_inicio(String urlInicio) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(urlInicio));
        assert driver.getCurrentUrl().equals(urlInicio);
    }
}
