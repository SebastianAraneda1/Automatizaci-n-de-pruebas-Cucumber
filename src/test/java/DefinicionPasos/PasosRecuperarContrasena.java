package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class PasosRecuperarContrasena {

    @Given("que puedo acceder a la aplicación {string}")
    public void que_puedo_acceder_a_la_aplicacion(String url) {
        PasosComunes.driver.get(url);
        System.out.println("Accediendo a la URL: " + url);
    }

    @When("hago click en el campo del correo {string}")
    public void hago_click_en_el_campo_del_correo(String correoXpath) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(correoXpath)));
        emailField.click();
        System.out.println("Haciendo click en el campo del correo.");
    }

    @When("relleno el campo con un correo existente en el sistema {string}")
    public void relleno_el_campo_con_un_correo_existente_en_el_sistema(String correo) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customer-email']")));
        emailField.clear();
        emailField.sendKeys(correo);
        System.out.println("Rellenando el campo con un correo existente en el sistema: " + correo);
    }

    @Then("me redirigirá al login {string}")
    public void me_redirigira_al_login(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(PasosComunes.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = PasosComunes.driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente al login.");
    }
}
