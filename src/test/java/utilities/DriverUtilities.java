package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class DriverUtilities {

    private DriverUtilities() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserType = PropertiesReader.getBrowser().toLowerCase();
            switch (browserType) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driverPool.set(new FirefoxDriver(firefoxOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driverPool.set(new EdgeDriver(edgeOptions));
                    break;

                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    driverPool.set(new SafariDriver(safariOptions));
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browserType);
            }

            if (PropertiesReader.isMaxWindow()) {
                DriverUtilities.getDriver().manage().window().maximize();
            }

            int implicitWait = Integer.parseInt(
                    PropertiesReader.getConfigProperty("implicit.wait") != null
                            ? PropertiesReader.getConfigProperty("implicit.wait")
                            : "10");

            int pageLoadTimeout = Integer.parseInt(
                    PropertiesReader.getConfigProperty("page.load.timeout") != null
                            ? PropertiesReader.getConfigProperty("page.load.timeout")
                            : "30");

            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
            driverPool.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        }

        return driverPool.get();

    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}