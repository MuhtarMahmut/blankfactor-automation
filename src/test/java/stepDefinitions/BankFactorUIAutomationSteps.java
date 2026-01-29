package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ContactPage;
import utilities.PropertiesReader;
import utilities.DriverUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.IndustriesPage;
import pages.RetirementWealthPage;
import utilities.PageUtilities;

public class BankFactorUIAutomationSteps {


    private static final Logger logger = LoggerFactory.getLogger(BankFactorUIAutomationSteps.class);
    private HomePage homePage;
    private IndustriesPage industriesPage;
    private RetirementWealthPage retirementWealthPage;
    private ContactPage contactPage;

    @Given("I am on the Blankfactor page")
    public void i_am_on_the_blankfactor_page() {
        logger.info("Navigating to Blankfactor URL");
        homePage = new HomePage();
        homePage.navigateToUrl(PropertiesReader.getUrl());
    }

    @Given("I accepted the cookies policy")
    public void i_accepted_the_cookies_policy() {
        homePage.acceptCookies();
        logger.info("Accepted cookies");
    }

    @When("I go to Industries section of the page")
    public void i_go_to_industries_section_of_the_page() {
        logger.info("Navigating to Industries section");
        homePage.goToIndustriesPage();
        industriesPage = new IndustriesPage();
    }

    @When("I click to open the Retirement and Wealth")
    public void i_click_to_open_the_retirement_and_wealth() {
        logger.info("Clicking and Opening Retirement and Wealth Page");
        industriesPage.clickRetirementWealthLearnMoreButton();
        retirementWealthPage = new RetirementWealthPage();
    }

    @When("I hover over the mouse to the AI & Machine learning flip card")
    public void i_hover_over_the_mouse_to_the_ai_machine_learning_flip_card() {
        logger.info("Hovering over AI & Machine learning flip card");
        retirementWealthPage.mouseHoverToAiMachineLearningFlipCard();
    }

    @When("I get the AI & Machine learning flip card text")
    public void i_get_the_ai_machine_learning_flip_card_text() {
        logger.info("Getting & Printing the AI & Machine learning flip card text");
        retirementWealthPage.printAiMachineLearningFlipCardMessage();
    }

    @When("I scroll to the bottom of the page")
    public void i_scroll_to_the_bottom_of_the_page() {
        logger.info("Scrolling to bottom of the page");
        retirementWealthPage.scrollToPageBottom();
    }

    @When("I click the Let's get started button")
    public void i_click_the_let_s_get_started_button() {
        logger.info("Clicking on the 'Let's get started' button");
        retirementWealthPage.clickLetsGetStartedButton();
        contactPage = new ContactPage();
    }

    @Then("I should be on the contact page")
    public void i_should_be_on_the_contact_page() {
        logger.info("Verifying contact page Title & URL");
        contactPage.verifyPageTitleEquals("Contact | Blankfactor");
        contactPage.verifyPageUrlEquals("https://blankfactor.com/contact/");
        contactPage.displayContactPageTitle();
        contactPage.displayContactPageUrl();
    }

}
