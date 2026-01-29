package pages;

import utilities.DriverUtilities;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;
import utilities.WaitUtilities;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverUtilities.getDriver(), this);
    }

    public void navigateToUrl(String url) {
        DriverUtilities.getDriver().get(url);
    }

    public void scrollToPageBottom() {
        PageUtilities.getJsExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToPageTop() {
        PageUtilities.getJsExecutor().executeScript("window.scrollTo(0, 0);");
    }

    public String getPageTitle() {
        return DriverUtilities.getDriver().getTitle();
    }

    public String getPageUrl() {
        return DriverUtilities.getDriver().getCurrentUrl();
    }

    public void verifyPageTitleEquals(String title) {
        WaitUtilities.waitForPageTitleEqualsTo(title);
    }

    public void verifyPageUrlEquals(String url) {
        WaitUtilities.waitForPageURLEqualsTo(url);
    }


}
