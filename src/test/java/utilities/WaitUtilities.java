package utilities;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtilities {

    public static WebDriverWait getWait() {
        int explicitWait = Integer.parseInt(
                PropertiesReader.getConfigProperty("explicit.wait") != null
                        ? PropertiesReader.getConfigProperty("explicit.wait")
                        : "10");
        return new WebDriverWait(DriverUtilities.getDriver(), Duration.ofSeconds(explicitWait));
    }

    public static void waitForPageTitleEqualsTo(String title) {
        getWait().until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(title, DriverUtilities.getDriver().getTitle());
    }

    public static void waitForPageTitleContains(String title) {
        getWait().until(ExpectedConditions.titleContains(title));
        Assert.assertTrue(DriverUtilities.getDriver().getTitle().contains(title));
    }

    public static void waitForPageURLEqualsTo(String url) {
        getWait().until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(url, DriverUtilities.getDriver().getCurrentUrl());
    }

    public static void waitForPageURLContains(String url) {
        getWait().until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(DriverUtilities.getDriver().getCurrentUrl().contains(url));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(element.isEnabled());
    }

}