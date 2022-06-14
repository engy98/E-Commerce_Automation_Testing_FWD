@regression
Feature: User could login to his account on the e-commerce app
  @logi
  Scenario: User could log in with valid email and password
    When User navigates to the login page
    And User enters email "a@a.com"
    And User enter password "12345678"
    And User press login button
    Then user login to the system successfully

 @logi
  Scenario: User could log in with invalid email and password
    When User navigates to the login page
    And User enters email "a@s.com"
    And User enter password "123678"
    And User press login button
    Then user could not login to the system successfully