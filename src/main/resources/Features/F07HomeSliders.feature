@regression
Feature: User will be able to open sliders in home page

  @slid
  Scenario: First slider is clickable
    Given user clicks on the slider "1"
    Then the url will be changed "https://demo.nopcommerce.com/nokia-lumia-1020"

    @slid
    Scenario: Second slider is clickable
      Given user clicks on the slider "2"
      Then the url will be changed "iphone"

