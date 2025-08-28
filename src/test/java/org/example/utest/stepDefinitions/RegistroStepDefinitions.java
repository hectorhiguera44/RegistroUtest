package org.example.utest.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utest.pages.UTestRegistrationPage;
import org.example.utest.utils.ConfigurationReader;
import org.example.utest.utils.ScreenshotHelper;
import org.example.utest.utils.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class RegistroStepDefinitions {
    private UTestRegistrationPage registrationPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        String browser = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.createWebDriver(browser);
        registrationPage = new UTestRegistrationPage(driver);
    }

    @Given("me encuentro en la página principal de UTest")
    public void me_encuentro_en_la_pagina_principal_de_u_test() {
        String baseUrl = ConfigurationReader.getProperty("base.url");
        driver.get(baseUrl);
    }

    @When("el usuario completa el formulario personal con los siguientes datos")
    public void el_usuario_completa_el_formulario_de_registro_con_los_siguientes_datos(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);


        registrationPage.clickJoinNow();

        String uniqueEmail;
        registrationPage.fillPersonalData(
                data.get(0).get("nombre"),
                data.get(0).get("apellido"),
                "testuser" + System.currentTimeMillis() + "@test.com",
                data.get(0).get("mes"),
                data.get(0).get("dia"),
                data.get(0).get("año"));

    }

    @And("el usuario avanza a la pagina locacion")
    public void el_usuario_avanza_a_la_pagina_locacion() {
        registrationPage.clickNextLocation();
    }

    @When("el usuario completa el formulario de ubicación con los siguientes datos")
    public void el_usuario_completa_el_formulario_de_ubicacion_con_los_siguientes_datos(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        registrationPage.fillLocationData(
                data.get("postalCode"),
                data.get("countryId")
        );
    }

    @And("el usuario avanza a la pagina dispositivo")
    public void el_usuario_avanza_a_la_pagina_dispositivo() {
        registrationPage.clickNextDevices();
    }

    @When("el usuario completa el formulario de dispositivos con los siguientes datos")
    public void el_usuario_completa_el_formulario_de_dispositivos_con_los_siguientes_datos(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        registrationPage.fillDevicesData(
                data.get("mobile"),
                data.get("modelo"),
                data.get("sistema_operativo")
        );
    }

    @And("el usuario avanza a la pagina seguridad")
    public void el_usuario_avanza_al_ultimo_paso() {
        registrationPage.clickLastStep();
    }

    @When("el usuario completa el formulario de seguridad con los siguientes datos")
    public void el_usuario_completa_el_formulario_de_seguridad_con_los_siguientes_datos(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        registrationPage.fillLastStep(data.get("password"));
    }

    @And("el usuario confirma los datos registrados")
    public void el_usuario_confirma_los_datos_registrados() {
        registrationPage.clickCompleteSetup();
    }

    @Then("el usuario debería ver el mensaje de confirmación {string}")
    public void el_usuario_deberia_ver_el_mensaje_de_confirmacion(String expectedMessage) {
        String actualMessage = registrationPage.getConfirmationText();
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("✅ La cuenta a sido registrada exitosamente.");
            // The test will pass implicitly here
        } else {
            System.out.println("❌ Error de validación: El mensaje de confirmación no es el esperado.");
            System.out.println("Mensaje esperado: " + expectedMessage);
            System.out.println("Mensaje real: " + actualMessage);
            // Fail the test explicitly
            Assert.fail("El mensaje de confirmación no coincide.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
