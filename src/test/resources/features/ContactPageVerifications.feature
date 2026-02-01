@a1
Feature: Contact Page URL and Title Verifications

  As a user, I should be able to navigate through the website and land on the contact page.

  Background:
    Given I am on the Blankfactor home page
    And I accepted the cookies policy

  Scenario: Verify contact page title and url
    When I go to Industries section of the page
    And I click to open the Retirement and Wealth
    And I hover over the mouse to the AI & Machine learning flip card
    And I get the AI & Machine learning flip card text
    And I scroll to the bottom of the page
    And I click the Let's get started button
    Then I should see the correct contact page title
    And I should see the correct contact page URL

