package org.example.utest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            // Carga el archivo desde el directorio raíz del proyecto
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Fallo al cargar el archivo configuration.properties! por favor revisa la ruta.");
        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
