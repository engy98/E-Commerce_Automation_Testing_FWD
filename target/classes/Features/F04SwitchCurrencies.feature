@regression
Feature: User could switch between currencies US-Euro
  @cur
  Scenario: User could switch between currencies US-Euro
    Given User press the currencies list and Select the "Euro" currency
    Then The currency of the prices of the products will be "€"