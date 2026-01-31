package pages;
import utilities.DriverUtilities;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverUtilities.getDriver(), this);
    }

    public void navigateToUrl(String url) {
        DriverUtilities.getDriver().get(url);
    }

    public void scrollToPageTop() {
        PageUtilities.getJsExecutor().executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToPageBottom() {
        PageUtilities.getJsExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getPageTitle() {
        return DriverUtilities.getDriver().getTitle();
    }

    public String getPageUrl() {
        return DriverUtilities.getDriver().getCurrentUrl();
    }


}
