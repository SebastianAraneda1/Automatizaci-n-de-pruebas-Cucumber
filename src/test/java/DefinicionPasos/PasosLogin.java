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
import static org.junit.Assert.assertEquals;

public class PasosLogin {
    static WebDriver driver;

    // --CHROME DRIVER--
    static String pathDriver = "./src/test/resources/chrome/chromedriver.exe";
    static String tipoDriver = "webdriver.chrome.driver";

    @Before
    public void setUp() throws Exception {
        System.setProperty(tipoDriver, pathDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Inicializando el navegador.");
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
            System.out.println("Cerrando el navegador.");
        }
    }

    @Given("que puedo acceder a la aplicación {string}")
    public void que_puedo_acceder_a_la_aplicacion(String url) {
        driver.get(url);
        System.out.println("Accediendo a la URL: " + url);
    }

    @When("puedo acceder al login {string}")
    public void puedo_acceder_al_login(String enlace) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enlace)));
        loginLink.click();
        System.out.println("Accediendo al enlace de login.");
    }

    @When("ingreso un email incorrecto en {string} con texto {string}")
    public void ingreso_un_email_incorrecto_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el email incorrecto: " + email);
    }

    @When("ingreso un email correcto en {string} con texto {string}")
    public void ingreso_un_email_correcto_en_con_texto(String emailXpath, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailXpath)));
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Ingresando el email correcto: " + email);
    }

    @When("ingreso una clave correcta en {string} con texto {string}")
    public void ingreso_una_clave_correcta_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando la clave correcta.");
    }
    
    @When("ingreso una clave incorrecta en {string} con texto {string}")
    public void ingreso_una_clave_incorrecta_en_con_texto(String passwordXpath, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordXpath)));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Ingresando la clave incorrecta.");
    }

    @When("realizo el envío de los datos apretando el botón {string}")
    public void realizo_el_envio_de_los_datos_apretando_el_boton(String buttonXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath)));
        button.click();
        System.out.println("Realizando el envío de los datos.");
    }

    @Then("redirige a un captcha {string}")
    public void redirige_a_un_captcha(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente al captcha.");
    }

    @Then("aparece mensaje Correo electrónico o contraseña incorrectos {string}")
    public void aparece_mensaje_error(String errorMessageXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        String actualMessage = errorMessage.getText();
        assertEquals("Correo electrónico o contraseña incorrectos", actualMessage.trim());
        System.out.println("Mensaje de error visible: " + actualMessage);
    }
}
