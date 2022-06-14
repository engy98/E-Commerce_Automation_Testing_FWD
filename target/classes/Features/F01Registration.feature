@regression
Feature: User could register to the e-commerce app
 @reg
  Scenario: User could register with valid data
    Given User navigates to the registration page
    When User enters the gender female
    And User enters the first name "engy"
    And User enters the last name "test"
    And User enters the birth date
    And User enters the email "a@a.com"
    And User enters the company name "BB"
    And User selects the newsletter
    And User enters password "12345678" and confirmation password "12345678"
    And User press register button
    Then success message is displayed

