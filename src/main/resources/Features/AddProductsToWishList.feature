@regression
Feature: User could add different products to Wishlist
 @wish
  Scenario: user could add different products to Wishlist
    Given User add a product "HTC One M8 Android L 5.0 Lollipop" to his wishlist
    Then the product added to the wishlist and see success msg "wishlist"

  @wish
  Scenario: user could add different products to Wishlist
    Given User add a product "HTC One M8 Android L 5.0 Lollipop" to his wishlist
    When user open wishlist
    Then the product exist in wishlist "HTC One M8 Android L 5.0 Lollipop"