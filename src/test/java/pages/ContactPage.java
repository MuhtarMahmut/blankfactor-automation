package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(RetirementWealthPage.class);

    public void displayContactPageTitle() {
        logger.info("Current page title: {}", getPageTitle());
    }

    public void displayContactPageUrl(){
        logger.info("Current page URL: {}", getPageUrl());
    }

}
