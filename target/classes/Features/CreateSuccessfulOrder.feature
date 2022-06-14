Feature: Successful Order
  @suc
  Scenario: Create successful Order
    Given User Log In
    When Select Category "Books"
    And Add product to shopping cart "Fahrenheit 451 by Ray Bradbury"
    And agree and press check out btn
    And fill payment information
    And select payment method and confirm
    Then see success msg
