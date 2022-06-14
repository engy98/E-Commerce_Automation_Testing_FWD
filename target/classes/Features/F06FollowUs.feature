@regression
Feature: User could follow us


  @fol
  Scenario: User follow us on facebook
    Given press the social media "Facebook"
    Then new window with this link "https://www.facebook.com/nopCommerce" will be opened

  @fol
  Scenario: User follow us on twitter
    Given press the social media "Twitter"
    Then new window with this link "https://twitter.com/nopCommerce" will be opened

  @fol
  Scenario: User follow us on RSS
    Given press the social media "RSS"
    Then new window with this link "https://demo.nopCommerce/new-online-store-is-opened" will be opened

  @fol
  Scenario: User follow us on YouTube
    Given press the social media "YouTube"
    Then new window with this link "https://www.youtube.com/user/nopCommerce" will be opened


