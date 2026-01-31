package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.WaitUtilities;

public class ContactPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ContactPage.class);

    public void verifyContactPageTitle() {
        WaitUtilities.waitForPageTitleEqualsTo("Contact | Blankfactor");
    }

    public void verifyContactPageUrl() {
        WaitUtilities.waitForPageURLEqualsTo("https://blankfactor.com/contact/");
    }

    public void displayContactPageTitle() {
        logger.info("Current page title: {}", getPageTitle());
    }

    public void displayContactPageUrl(){
        logger.info("Current page URL: {}", getPageUrl());
    }

}
