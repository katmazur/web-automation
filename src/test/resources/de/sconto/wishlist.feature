Feature: Sconto Adding to Favourite Feature
  In order to save product for later
  I add product to the Wishlist

  Scenario: Successful Adding to the Wishlist when you initially aren't logged in
    Given I am on the Product Listing Page
    When I click on the Wishlist icon
    Then I see Login request form

    When I click on the Login button at the Login request form
    Then I see Login page

    When I insert valid user credentials
    And I click on Login button at the Login Page
    Then I should see WishListPage
    And the product is added to the WishListPage
    And I see that Wishlist icon state at the header is changed

