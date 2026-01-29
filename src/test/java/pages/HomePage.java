package pages;

import org.openqa.selenium.Cookie;
import utilities.PageUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverUtilities;

public class HomePage extends BasePage {

    @FindBy(xpath = "//nav//a[contains(@href,'industries')]")
    public WebElement industriesBootStrapLink;


    public void acceptCookies() {
        DriverUtilities.getDriver().manage().addCookie(new Cookie.Builder("cookie_consent_accepted", "true")
                .domain("blankfactor.com").build());
        DriverUtilities.getDriver().navigate().refresh();
    }

    public void goToIndustriesPage() {
        PageUtilities.click(industriesBootStrapLink);
    }

}