package config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Environment {
    private static Logger logger = LoggerFactory.getLogger(Environment.class);

    private PropertiesFiles prop = new PropertiesFiles();

    private Properties newEnv = prop.loadPropertiesFile("environment.properties");

    private String getEnv(String env) {
        return System.getProperty(env);
    }

    private String getEnv(String env, String defaultValue) {
        String var = getEnv(env);
        if (StringUtils.isEmpty(var))
            return defaultValue;
        return var;
    }

    public String getSeleniumgridUrl() {
        return newEnv.getProperty("SELENIUMGRID_URL");
    }

    //Other way of handling properties:

    private String getBaseUrlProperty() {return newEnv.getProperty("BASE_URL");
    }
    public String getBaseUrl() { return getEnv("API_KEY", getBaseUrlProperty());
    }

}
