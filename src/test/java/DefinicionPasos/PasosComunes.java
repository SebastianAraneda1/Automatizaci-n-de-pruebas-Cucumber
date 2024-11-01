package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.time.Duration;

public class PasosComunes {
    public static WebDriver driver;

    // Configuración del ChromeDriver
    static String pathDriver = "./src/test/resources/chrome/chromedriver.exe";
    static String tipoDriver = "webdriver.chrome.driver";

    @Before
    public void setUp() throws Exception {
        if (driver == null) {
            System.setProperty(tipoDriver, pathDriver);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            System.out.println("Inicializando el navegador.");
        }
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Cerrando el navegador.");
        }
    }

    @Given("que puedo acceder a la aplicación {string}")
    public void que_puedo_acceder_a_la_aplicacion(String url) {
        driver.get(url);
        System.out.println("Accediendo a la URL: " + url);
    }
    
    @When("realizo el envío de los datos apretando el botón {string}")
    public void realizo_el_envio_de_los_datos_apretando_el_boton(String botonXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(botonXpath)));
        submitButton.click();
        System.out.println("Realizando el envío de los datos.");
    }
}
