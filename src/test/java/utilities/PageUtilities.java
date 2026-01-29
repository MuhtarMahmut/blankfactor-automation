package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtilities {

    // Create JavascriptExecutor on-demand to avoid stale driver references
    public static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) DriverUtilities.getDriver();
    }

    public static void scrollToElement(WebElement element) {
        getJsExecutor().executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
    }

    public static void scrollToElementIfNeeded(WebElement element) {
        Boolean isInViewport = (Boolean) getJsExecutor().executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "  rect.top >= 0 &&" +
                        "  rect.left >= 0 &&" +
                        "  rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                        "  rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                        ");",
                element);

        if (!isInViewport) {
            scrollToElement(element);
        }
    }

    public static void click(WebElement element) {
        scrollToElementIfNeeded(element);
        WaitUtilities.waitForElementToBeClickable(element);
        element.click();
    }

    public static void mouseHover(WebElement element) {
        scrollToElementIfNeeded(element);
        Actions actions = new Actions(DriverUtilities.getDriver());
        actions.moveToElement(element).perform();
    }

    public static String getText(WebElement element) {
        scrollToElementIfNeeded(element);
        WaitUtilities.waitForElementToBeVisible(element);
        return element.getText();
    }



}
