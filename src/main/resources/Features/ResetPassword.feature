@regression
Feature: User could reset his/her password

@res
  Scenario: User could reset his/her password successfully
    Given User navigates to login page
    When User press forgot password button
    And User enters his valid email "a@v.com"
    And User press recover button
    Then User see success message "Email with instructions has been sent to you."