Feature: Sconto Wishlist
  In order to save product for later
  I add product to the Wishlist

  @Wishlist
  Scenario: Add product to the wishlist for not logged in user
    Given I am on the Product Listing Page
    When I click on the Wishlist icon
    Then I see Login popup

    When When I click on Login button at Login popup
    Then I see "LoginPage"

    When I insert valid user credentials
    And I click on Login button
    Then I see "WishListPage"
    And the product is added to the WishListPage
    And I see that Wishlist icon state at the header is changed

