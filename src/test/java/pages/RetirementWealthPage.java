package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PageUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetirementWealthPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(RetirementWealthPage.class);

    @FindBy(xpath = "//h2[@class='h2 heading section-title  scroll-animation  fade ']")
    public WebElement poweringInnovationRetirementServicesHeader;

    @FindBy(xpath = "//div[@class='flip-card-front card-front']//div[@class='card-text' and contains(.,'Machine learning')]")
    public WebElement aiMachineLearningFlipCard;

    @FindBy(xpath = "//div[contains(@class,'flip-card') and .//div[contains(@class,'card-front')]//div[contains(.,'AI &') and contains(.,'Machine learning')]]//div[@class='card-text small']")
    public WebElement aiMachineLearningFlipCardMessages;

    @FindBy(xpath = "//a[@title=\"Let's get started\"]")
    public WebElement letsGetStartedButton;

    public void mouseHoverToAiMachineLearningFlipCard() {
        logger.debug("Hovering over AI & Machine Learning flip card");
        PageUtilities.mouseHover(aiMachineLearningFlipCard);
    }

    public String getAiMachineLearningFlipCardMessage() {
        String message = PageUtilities.getText(aiMachineLearningFlipCardMessages);
        logger.debug("Retrieved flip card message: {}", message);
        return message;
    }

    public void clickLetsGetStartedButton() {
        logger.debug("Clicking 'Let's get started' button");
        PageUtilities.click(letsGetStartedButton);
    }

    public void scrollToPoweringInnovationRetirementServices() {
        logger.debug("Scrolling to 'Powering Innovation in Retirement Services' section");
        PageUtilities.scrollToElement(poweringInnovationRetirementServicesHeader);
    }

    public void printAiMachineLearningFlipCardMessage() {
        mouseHoverToAiMachineLearningFlipCard();
        String message = getAiMachineLearningFlipCardMessage();
        logger.info("AI & Machine Learning flip card message: {}", message);
    }

}