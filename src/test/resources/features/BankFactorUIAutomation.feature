@a1
Feature: Blank factor Website Navigation and Verification

  Background:
    Given I am on the Blankfactor page
    And I accepted the cookies policy

  Scenario: Navigate through multiple Blank factor pages and verify the contact page titles and ruls.
    When I go to Industries section of the page
    And I click to open the Retirement and Wealth
    And I hover over the mouse to the AI & Machine learning flip card
    And I get the AI & Machine learning flip card text
    And I scroll to the bottom of the page
    And I click the Let's get started button
    Then I should be on the contact page




