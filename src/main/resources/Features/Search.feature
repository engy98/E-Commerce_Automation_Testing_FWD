@regression
Feature: User could search for products
 @search
  Scenario Outline: user could search using product name
    Given User write the product name "<name>" in the text field
    Then User see the product he searched for "<name>"

   Examples:
   | name |
   |book  |
   |laptop|
   |nike  |

   @search
   Scenario Outline: user could search for product using sku
     Given User write the product sku "<sku>" in the text field
     When User press the product
     Then User see the sku of product he searched for "<sku>"

     Examples:
     |sku|
     |SCI_FAITH|
     |APPLE_CAM|
     |SF_PRO_11|