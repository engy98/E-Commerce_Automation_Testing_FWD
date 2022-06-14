@regression
Feature: User could add different products to compare list


@compare
  Scenario: Logged user could add different products to compare list
    Given login to the app
    When select the category "Books"
    And User add a product "Fahrenheit 451 by Ray Bradbury" to his compare list
    And User add another product "Flower Girl Bracelet" to his compare list from category "Jewelry"
    And User open compare list
    Then User see the products "Fahrenheit 451 by Ray Bradbury" and "Flower Girl Bracelet" in the compare list