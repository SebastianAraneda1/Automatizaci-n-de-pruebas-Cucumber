package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PasosCheckout {

    private WebDriver driver = PasosComunes.driver;

    // ACCEDER AL ENLACE
    @Given("que pude añadir un producto al carrito de compras y voy al enlace del checkout {string}")
    public void que_pude_añadir_un_producto_al_carrito_de_compras_y_voy_al_enlace_del_checkout(String checkoutUrl) {
        driver.get(checkoutUrl);
    }

    // INGRESAR CORREO ELECTRÓNICO
    @When("ingreso un email {string}")
    public void ingreso_un_email(String emailXpath, String email) {
        enterText(emailXpath, email, "Ingresando correo electrónico.");
    }

    // INGRESAR NOMBRE
    @When("ingreso un nombre {string}")
    public void ingreso_un_nombre(String nombreXpath, String nombre) {
        enterText(nombreXpath, nombre, "Ingresando nombre.");
    }

    // INGRESAR APELLIDO
    @When("ingreso un apellido {string}")
    public void ingreso_un_apellido(String apellidoXpath, String apellido) {
        enterText(apellidoXpath, apellido, "Ingresando apellido.");
    }

    // INGRESAR DIRECCIÓN
    @When("ingreso una dirección {string}")
    public void ingreso_una_direccion(String direccionXpath, String direccion) {
        enterText(direccionXpath, direccion, "Ingresando dirección.");
    }

    // INGRESAR COMUNA
    @When("ingreso una comuna {string}")
    public void ingreso_una_comuna(String comunaXpath, String comuna) {
        enterText(comunaXpath, comuna, "Ingresando comuna.");
    }

    // INGRESAR TELÉFONO
    @When("ingreso un teléfono {string}")
    public void ingreso_un_telefono(String telefonoXpath, String telefono) {
        enterText(telefonoXpath, telefono, "Ingresando teléfono.");
    }

    // SELECCIONAR TIPO DE ENTREGA
    @When("selecciono tipo de entrega {string}")
    public void selecciono_tipo_de_entrega(String tipoEntregaXpath) {
        clickElement(tipoEntregaXpath, "Seleccionando tipo de entrega.");
    }

    // VALIDAR SUCURSALES DISPONIBLES
    @Then("me aparecerán las sucursales de retiro disponibles {string}")
    public void me_apareceran_las_sucursales_de_retiro_disponibles(String sucursalesXpath) {
        verifyElementsVisibility(sucursalesXpath, "Sucursales de retiro disponibles visibles.");
    }

    // SELECCIONAR TIPO DE PAGO
    @When("selecciono tipo de pago {string}")
    public void selecciono_tipo_de_pago(String tipoPagoXpath) {
        clickElement(tipoPagoXpath, "Seleccionando tipo de pago.");
    }

    // VALIDAR MENSAJE CON INSTRUCCIONES DE PAGO
    @Then("me aparecerá un mensaje con instrucciones {string}")
    public void me_aparecera_un_mensaje_con_instrucciones(String mensajeXpath) {
        verifyElementsVisibility(mensajeXpath, "Mensaje con instrucciones de pago visible.");
    }

    // SELECCIONAR USAR DATOS DISTINTOS
    @When("selecciono en datos cliente {string}")
    public void selecciono_en_datos_cliente(String datosClienteXpath) {
        clickElement(datosClienteXpath, "Seleccionando 'Usar datos distintos a los del envío'.");
    }

    // VALIDAR FORMULARIO DE DATOS DISTINTOS
    @Then("me aparecerá un formulario {string}")
    public void me_aparecera_un_formulario(String formularioXpath) {
        verifyElementsVisibility(formularioXpath, "Formulario de datos distintos visible.");
    }

    // VALIDAR CAMPOS OBLIGATORIOS AL PAGAR SIN RELLENAR
    @Then("me validarán los campos {string}, {string}, {string} y {string}")
    public void me_validaran_los_campos(String nombreXpath, String apellidoXpath, String direccionXpath, String comunaXpath) {
        verifyElementsVisibility(nombreXpath, "Campo nombre validado.");
        verifyElementsVisibility(apellidoXpath, "Campo apellido validado.");
        verifyElementsVisibility(direccionXpath, "Campo dirección validado.");
        verifyElementsVisibility(comunaXpath, "Campo comuna validado.");
    }

    // HACER CLICK EN PAGAR
    @When("hago click en el botón pagar {string}")
    public void hago_click_en_el_boton_pagar(String botonPagarXpath) {
        clickElement(botonPagarXpath, "Haciendo click en el botón pagar.");
    }

    // VALIDAR REDIRECCIÓN A PANTALLA DE PAGO
    @Then("me redireccionará a {string}")
    public void me_redireccionara_a(String redireccionUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(redireccionUrl));
        assertTrue("Redirección a pantalla de pago fallida.", driver.getCurrentUrl().equals(redireccionUrl));
    }

    // Helper method to click an element
    private void clickElement(String xpath, String actionDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
            System.out.println(actionDescription);
        } catch (Exception e) {
            System.out.println("Error al intentar realizar la acción: " + actionDescription + ". Error: " + e.getMessage());
            fail("No se pudo hacer clic en el elemento: " + actionDescription);
        }
    }

    // Helper method to enter text in a field
    private void enterText(String xpath, String text, String actionDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
            System.out.println(actionDescription);
        } catch (Exception e) {
            System.out.println("Error al intentar ingresar texto: " + actionDescription + ". Error: " + e.getMessage());
            fail("No se pudo ingresar texto en el elemento: " + actionDescription);
        }
    }

    // Helper method to verify visibility of elements
    private void verifyElementsVisibility(String xpath, String successMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            assertTrue("No se encontraron elementos visibles para la verificación.", elements.size() > 0);
            elements.forEach(element -> System.out.println(successMessage));
        } catch (Exception e) {
            System.out.println("Error al verificar la visibilidad de los elementos. Error: " + e.getMessage());
            fail("No se pudo verificar la visibilidad de los elementos.");
        }
    }
}
