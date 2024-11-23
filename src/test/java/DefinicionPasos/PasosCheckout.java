package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PasosCheckout {
    
    private WebDriver driver = PasosComunes.driver;

    @Given("que pude añadir un producto al carrito de compras y voy al enlace del checkout {string}")
    public void que_pude_añadir_un_producto_al_carrito_de_compras_y_voy_al_enlace_del_checkout(String url) {
        driver.get(url);
    }

    @When("ingreso un email {string} {string}")
    public void ingreso_un_email(String xpath, String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(1500);
    }

    @When("ingreso un nombre {string} {string}")
    public void ingreso_un_nombre(String xpath, String nombre) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement nombreField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
        // Desplazarse hasta el elemento si no está en la vista
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nombreField);
        
        // Asegurarse de que el elemento es clickeable
        wait.until(ExpectedConditions.elementToBeClickable(nombreField));
        nombreField.click();
        nombreField.clear();
        nombreField.sendKeys(nombre);
        Thread.sleep(1500);
    }


    
    @When("ingreso un apellido {string} {string}")
    public void ingreso_un_apellido(String xpath, String apellido) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement apellidoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        apellidoField.click();
        apellidoField.clear();
        apellidoField.sendKeys(apellido);
        Thread.sleep(1500);
    }

    @When("ingreso una dirección {string} {string}")
    public void ingreso_una_direccion(String xpath, String direccion) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement direccionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        direccionField.click();
        direccionField.clear();
        direccionField.sendKeys(direccion);
        Thread.sleep(1500);
    }

    @When("ingreso una comuna {string} {string}")
    public void ingreso_una_comuna(String xpath, String comuna) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement comunaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        comunaField.click();
        comunaField.clear();
        comunaField.sendKeys(comuna);
        Thread.sleep(1500);
    }
    
    @When("ingreso una comuna inexistente {string} {string}")
    public void ingreso_una_comuna_inexistente(String xpath, String comunaInexistente) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement comunaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        comunaField.click();
        comunaField.clear();
        comunaField.sendKeys(comunaInexistente);
        Thread.sleep(1500);
    }

    @When("ingreso un teléfono {string} {string}")
    public void ingreso_un_telefono(String xpath, String telefono) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement telefonoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        telefonoField.click();
        telefonoField.clear();
        telefonoField.sendKeys(telefono);
        Thread.sleep(1500);
    }

    @When("hago click en el botón pagar {string}")
    public void hago_click_en_el_boton_pagar(String botonPagarXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement pagarButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(botonPagarXpath)));
        
        // Desplazarse hasta el botón si no está en la vista
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pagarButton);
        
        // Asegurarse de que el botón es clickeable
        wait.until(ExpectedConditions.elementToBeClickable(pagarButton));
        pagarButton.click();
        System.out.println("Haciendo click en el botón pagar.");
    }

    @Then("me dará un error en comuna {string}")
    public void me_dara_un_error_en_comuna(String mensajeErrorXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mensajeErrorXpath)));
        assertTrue("Error en comuna no visible", errorElement.isDisplayed());
        System.out.println("Error en comuna visible.");
    }

    @When("selecciono tipo de pago {string}")
    public void selecciono_tipo_de_pago(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement tipoPagoField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        tipoPagoField.click();
        System.out.println("Seleccionando tipo de pago.");
    }

    @Then("me redireccionará a pantalla de pago {string}")
    public void me_redireccionara_a_pantalla_de_pago(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        System.out.println("Redirigido correctamente a la pantalla de pago.");
    }
    
    // Paso para acceder al catálogo
    @When("puedo acceder al catalogo enn {string}")
    public void puedo_acceder_al_catalogo_enn(String catalogXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement catalogLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(catalogXpath)));
        catalogLink.click();
        System.out.println("Accediendo al catálogo.");
    }
    
    // Paso para hacer clic en el botón "Agregar al carrito" en un producto
    @When("clickeo el boton Agregar al carrito en un productoo {string}")
    public void clickeo_el_boton_agregar_al_carrito_en_un_productoo(String botonXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(botonXpath)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        try {
            addToCartButton.click();
            System.out.println("Clickeando en el botón 'Agregar al carrito' en el producto.");
        } catch (Exception e) {
            System.out.println("Elemento no clickeable directamente, intentando con JavaScript.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }

        WebElement cartDrawer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-drawer']/div[1]")));
        assertTrue("El menú lateral no se muestra correctamente después de agregar el producto", cartDrawer.isDisplayed());
    }
    
    // Paso para ir al enlace del carrito después de añadir un producto
    @When("que pude añadir un producto al carrito de compras y voy al enlace del carritoo {string}")
    public void que_pude_añadir_un_producto_al_carrito_y_voy_al_enlace_del_carritoo(String carritoUrl) {
        driver.get(carritoUrl);
        System.out.println("Accediendo al enlace del carrito: " + carritoUrl);
    }


    @When("voy a finalizar compra {string}")
    public void voy_a_finalizar_compra(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try {
            System.out.println("Esperando a que el botón de finalizar compra sea clickeable. XPath: " + xpath);
            WebElement finalizarCompraButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            
            // Desplazarse hasta el botón si no está en la vista
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", finalizarCompraButton);
            
            // Hacer clic en el botón usando JavaScript para evitar la intercepción del clic
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalizarCompraButton);
            System.out.println("Haciendo click en el botón de finalizar compra.");
        } catch (Exception e) {
            System.out.println("No se pudo encontrar o hacer click en el botón de finalizar compra. Error: " + e.getMessage());
            throw e;
        }
    }



	@When("selecciono en datos cliente {string}")
	public void selecciono_en_datos_cliente(String string2) {
		driver.findElement(By.xpath(string2)).click();
	}
	
	@When("selecciono en datos cliente Usar datos distintos a los del envío {string}")
	public void selecciono_en_datos_cliente_usar_datos_distintos_a_los_del_envío(String string) {
		driver.findElement(By.xpath(string)).click();
	}
	
	@When("voy al carrito con producto {string}")
	public void voy_al_carrito_con_producto(String string) {
		driver.get(string);
	}
	
	@When("acepto terminos y condiciones {string}")
	public void acepto_terminos_y_condiciones(String xpath) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	    // Desplazarse hasta el checkbox si no está en la vista
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);

	    // Hacer clic en el checkbox usando JavaScript para evitar la intercepción del clic
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);
	    System.out.println("Aceptando términos y condiciones.");
	}
	
	@When("hago click en el botón Pagar ahora sin rellenar campos {string}")
	public void hago_click_en_el_botón_pagar_ahora_sin_rellenar_campos(String string) {
		driver.findElement(By.xpath(string)).click();
	}

	@Then("me redireccionará a flow {string}")
	public void me_redireccionará_a_flow(String string) {
		driver.get(string);
	}

	public void handleAlertIfPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        System.out.println("Alerta aceptada.");
	    } catch (Exception e) {
	        System.out.println("No hay alerta presente.");
	    }
	}

}
