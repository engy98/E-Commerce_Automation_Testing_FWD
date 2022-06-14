@regression
Feature: User could select different tags
 @tag
  Scenario: Logged user could select different tags
    Given login
    When User Select Category "Books"
    And User press "awesome" tag
    Then the "awesome" tag will be displayed in the title