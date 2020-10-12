package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFiles {

    Properties prop = new Properties();

    public Properties loadPropertiesFile(String filePath) {
        System.out.println("Filepath is" + filePath);

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}
