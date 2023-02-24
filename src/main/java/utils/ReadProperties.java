package utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadProperties {
    // Returns a value from Configurations.properties file based on propertyKey arg
    private static String readConfigValues(String propertyKey) {
        Properties properties = null;
        // Try block to check exception
        try {
            InputStream propertyFile = Files.newInputStream(Paths.get("C:/Users/Veljko Blagojevic/IdeaProjects/InternshipSaucedemo/src/main/java/constants/Configurations.properties"));
            properties = new Properties();
            properties.load(propertyFile);
        }
        // Catch block to handle exceptions
        catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyKey);
    }

    // Returns value from Configurations.properties file using 'browser' as key
    public static String readConfigBrowser() {
        return readConfigValues("browser");
    }

    // Returns value from Configurations.properties file using 'startUrl' as key
    public static String readConfigUrl() {
        return readConfigValues("startUrl");
    }

    // Returns value from Configurations.properties file using 'path' as key
    public static String readConfigChromePath() {
        return readConfigValues("chromeDriverPath");
    }
    // Returns value from Configurations.properties file using 'path' as key
    public static String readConfigFirefoxPath() {
        return readConfigValues("firefoxDriverPath");
    }
    // Returns value from Configurations.properties file using 'path' as key
    public static String readConfigEdgePath() {
        return readConfigValues("edgeDriverPath");
    }
}
