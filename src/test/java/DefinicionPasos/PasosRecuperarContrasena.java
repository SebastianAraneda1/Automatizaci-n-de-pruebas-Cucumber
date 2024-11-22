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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class PasosRecuperarContrasena {
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
    
    @When("hago click en el campo del correo {string}")
    public void hago_click_en_el_campo_del_correo(String campoXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(campoXpath)));
        emailField.click();
        System.out.println("Haciendo click en el campo del correo.");
    }

    @When("relleno el campo con un correo existente en el sistema {string}")
    public void relleno_el_campo_con_un_correo_existente_en_el_sistema(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@id='customer-email']"));
        emailField.sendKeys(email);
        System.out.println("Rellenando el campo del correo con: " + email);
    }

    @Then("me redirigirá al login {string}")
    public void me_redirigira_al_login(String loginUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(loginUrl));
        System.out.println("Redirigido al login: " + loginUrl);
    }
}
