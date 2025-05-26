Feature: Swag Labs
  Scenario Outline: Login as a standard user to verify the products page and logout from the application

    Given  User launch the Edge browser
    When  User opens URL "https://www.saucedemo.com/"
    Then  User verify the title
    And   User verify the username and password fields
    When  Provide login "<Email>" and Password "<password>"
    Then  User Verify the Landing page logo and URL
    Then  User Verify the PRODUCTS title and peek image visible on the home page
    Then  Click about in the burger menu and back
    Then  User Verify all the options Burger menu item
    Then  User Verify the shopping cart icon and product sort container visible on the top right of the page
    Then  Verify the Inventory Product item list is visible
    When  Select the Product sort container as Price low to high
    And   Verify the Twitter, Facebook, Linkedin logo visible
    Then  Click on Twitter social link and verify user is navigated to Twitter page
    Then  Click on Facebook social link and verify user is navigated to Facebook page
    Then  Click on LinkedIn social link and verify user is navigated to LinkedIn page
    Then  User logout from the application and verify the login page
    And   Close the tab

    Examples:
      | Email                        |         password           |
      |   standard_user              |       secret_sauce         |
      |    visual_user               |       secret_sauce         |
