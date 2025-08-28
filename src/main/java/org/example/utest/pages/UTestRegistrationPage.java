package org.example.utest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UTestRegistrationPage {
    private WebDriver driver;

    // Localizadores de los elementos

    //Comienzo Registro
    private By joinNowButton = By.linkText("Join Now");
    //Informacion personal
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By birthMonthSelect = By.id("birthMonth");
    private By birthDaySelect = By.id("birthDay");
    private By birthYearSelect = By.id("birthYear");
    //Locacion
    private By nextLocationButton = By.xpath("//span[contains(text(), 'Next: Location')]/.. ");
    private By postalCodeField = By.id("zip");
    private By countryIdSelect = By.id("countryId");
    //Dispositivo
    private By nextDevicesButton = By.xpath("//span[contains(text(), 'Next: Devices')]/.. ");
    private By SelectBrandSelect = By.cssSelector("span[aria-label='Select Brand']");
    private By SelectModelSelect = By.cssSelector("span[aria-label='Select a Model']");
    private By OperatingSystemSelect =By.xpath("//input[@id='focusser-5']//span[@aria-label='Select OS']/..");
    //Seguridad
    private By lastStepButton = By.xpath("//span[contains(text(), 'Next: Last Step')]/.. ");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By stayInformedCheck = By.cssSelector(".checkmark.signup-consent__checkbox.signup-consent__checkbox--highlight");
    private By termsOfUseCheck = By.xpath("//span[contains(text(), 'You must accept Terms of Use and uTest Guidelines to be able to continue')]/.. ");
    private By privacySecurityCheck = By.cssSelector("span.checkmark.signup-consent__checkbox.error");
    //Confirmacion final
    private By completeSetupButton = By.xpath("//span[contains(text(), 'Complete Setup')]/.. ");
    private By lastStepHeader = By.xpath("//h1[contains(text(),\"Welcome to the world's largest community of freelance software testers!\")]");


    // Localizador del botón para aceptar las cookies (Pop-up)
    private By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public UTestRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos de acción

    public void clickJoinNow() {
        // Llama al método para cerrar el pop-up de cookies si está presente.
        handleCookiePopup();

        // Espera y hace clic en el botón "Join Now". Aumentamos el tiempo a 20s para mayor seguridad.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(joinNowButton)).click();
    }

    private void handleCookiePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Espera a que el botón de cookies sea visible.
            WebElement cookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesButton));
            // Hace clic en el botón para cerrar el pop-up.
            cookieButton.click();
            System.out.println("Pop-up de cookies aceptado.");
        } catch (Exception e) {
            // Si el elemento no se encuentra, simplemente ignora el error y continúa.
            System.out.println("No se encontró el pop-up de cookies, continuando con el test.");
        }
    }

    public void fillPersonalData(String firstName, String lastName, String email, String birthMonth, String birthDay, String birthYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(birthMonthSelect));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText(birthMonth);
        WebElement dayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(birthDaySelect));
        Select daySelect = new Select(dayElement);
        daySelect.selectByVisibleText(birthDay);
        WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(birthYearSelect));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByVisibleText(birthYear);
        wait.until(ExpectedConditions.elementToBeClickable(nextLocationButton));
    }

    public void clickNextLocation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextLocationButton)).click();
    }

    public void  fillLocationData(String zip, String countryId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(zip);
        WebElement countryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countryIdSelect));
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(countryId);
        wait.until(ExpectedConditions.elementToBeClickable(nextDevicesButton));
    }

    public void clickNextDevices(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nextDevicesButton)).click();
    }
    public void fillDevicesData(String mobileDevice, String model, String operatingSystem){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Select the Mobile Device
        WebElement mobileElement = wait.until(ExpectedConditions.elementToBeClickable(SelectBrandSelect));
        mobileElement.click();
        WebElement mobileOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + mobileDevice + "')]")));
        mobileOption.click();

        // Select the Model
        WebElement modelElement = wait.until(ExpectedConditions.elementToBeClickable(SelectModelSelect));
        modelElement.click();
        WebElement modelOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + model + "')]")));
        modelOption.click();

        //Select the Operating System
        //WebElement systemElement = wait.until(ExpectedConditions.elementToBeClickable(OperatingSystemSelect));
        //systemElement.click();
        //WebElement systemOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + operatingSystem + "')]")));
        //systemOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(lastStepButton));

    }

    public void clickLastStep(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastStepButton)).click();
    }

    public void fillLastStep(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(stayInformedCheck)).click();
        wait.until(ExpectedConditions.elementToBeClickable(termsOfUseCheck)).click();
        wait.until(ExpectedConditions.elementToBeClickable(privacySecurityCheck)).click();

    }

    public void clickCompleteSetup(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(completeSetupButton)).click();

    }
    public String getConfirmationText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastStepHeader));
        return confirmationElement.getText();
    }
}
