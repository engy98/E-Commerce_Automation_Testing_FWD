@regression
Feature: User could add different products to Shopping cart
  @shop
  Scenario: Logged user could add different products to Shopping cart
    Given User login to app
    When User select category "Digital downloads" to add to shopping cart
    And User add a product "If You Wait (donation)" to his shopping cart
    And User add another product "Science & Faith" to his shopping cart from category "Digital downloads"
    And User open shopping cart
    Then User see the products "If You Wait (donation)" and "Science & Faith" that he added