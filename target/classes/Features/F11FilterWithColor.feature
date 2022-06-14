@regression
Feature: User could filter with color
  @fil
  Scenario: Logged user could filter with color
    Given User Login
    When User select category "Apparel" and subcategory "Shoes"
    And User filter with color red "rgba(138, 55, 74, 1)"
    Then The color "rgba(138, 55, 74, 1)" will be selected