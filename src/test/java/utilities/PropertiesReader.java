package utilities;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;

    static {
        try {
            InputStream input = PropertiesReader.class.getClassLoader()
                    .getResourceAsStream("properties/Configuration.properties");

            if (input == null) {
                throw new RuntimeException("Unable to find Configuration.properties in classpath");
            }

            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration properties: " + e.getMessage());
        }
    }

    public static String getUrl() {
        String environment = getConfigProperty("environment");
        if (environment != null) {
            return switch (environment.toLowerCase()) {
                case "stg" -> getConfigProperty("stg");
                case "dev" -> getConfigProperty("dev");
                case "uat" -> getConfigProperty("uat");
                case "prod" -> getConfigProperty("prod");
                default -> getConfigProperty("test");
            };
        }else{
            throw new RuntimeException("Environment not specified in Configuration.properties");
        }
    }

    public static String getConfigProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return getConfigProperty("browser");
    }

    public static boolean isMaxWindow() {
        return "true".equalsIgnoreCase(getConfigProperty("max_window"));
    }

    public static boolean isHeadless() {
        return "true".equalsIgnoreCase(getConfigProperty("headless"));
    }



}
