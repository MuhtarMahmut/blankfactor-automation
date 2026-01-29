package pages;

import utilities.PageUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndustriesPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'retirement-and-wealth') and normalize-space(text())='Learn More']")
    public WebElement retirementWealthLearnMoreButton;



    public void clickRetirementWealthLearnMoreButton() {
        PageUtilities.click(retirementWealthLearnMoreButton);
    }


}