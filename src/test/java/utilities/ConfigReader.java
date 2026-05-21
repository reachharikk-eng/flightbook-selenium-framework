package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties;

    public ConfigReader() {

        try {

            FileInputStream file = new FileInputStream(
                    "src/test/resources/config.properties");

            properties = new Properties();

            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getBrowser() {

        return properties.getProperty("browser");
    }

    public String getBaseUrl() {

        return properties.getProperty("baseUrl");
    }

    public int getTimeout() {

        return Integer.parseInt(
                properties.getProperty("timeout"));
    }

    public boolean isHeadless() {

        return Boolean.parseBoolean(
                properties.getProperty("headless"));
    }
}
