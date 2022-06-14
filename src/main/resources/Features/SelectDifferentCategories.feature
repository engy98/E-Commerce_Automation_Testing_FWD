@regression
Feature: User could select different Categories
  @cat

  Scenario: user could select different Categories
    Given User hover category name "Computers" and press subcategory "Desktops" if found
    Then the category name "Desktops" will be displayed