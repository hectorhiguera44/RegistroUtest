package org.example.utest.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "target/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot guardado en: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }
}
