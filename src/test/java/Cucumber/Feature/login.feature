@WeHere
Feature: Verification of Amazon Application

  Background:
    Given user Opens the browser and load the url
    When Click on login link
    Then Verify page title
    Then login page should appear

  Scenario:Logging into application
    Given Entering username and password with data in excel at "C:\Users\Nagaraj\IdeaProjects\TestFine\Drivers\ReadData.xlsx"
    When user should be navigated to Home Screen




