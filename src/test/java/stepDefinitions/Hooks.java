package stepDefinitions;

import utilities.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setup() {
        DriverUtilities.getDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverUtilities.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            Allure.addAttachment("Failed Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
        }
        DriverUtilities.closeDriver();
    }


}