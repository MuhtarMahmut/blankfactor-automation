package pages;

import utilities.PageUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndustriesPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space(text())='Learn More' and contains(@href,'retirement-and-wealth')]")
    public WebElement retirementWealthLearnMoreButton;


    public void clickRetirementWealthLearnMoreButton() {
        PageUtilities.click(retirementWealthLearnMoreButton);
    }


}