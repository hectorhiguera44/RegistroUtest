package org.example.utest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver createWebDriver(String browser) {
        if (driver == null) {
            // Asigna la ruta del driver de Chrome antes de crearlo
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            switch (browser.toLowerCase()) {
                case "chrome":
                    // opciones para manejar problemas de conexión con el driver
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    // Asumiendo que el driver de Gecko está en el classpath
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
