Feature: Sconto Adding to Favourite Feature
  In order to save product for later
  I add product to the Wishlist

  Background: User is Logged In
    Given I should be logged in

  @needCleanup
  Scenario: Successful Adding to the Wishlist
    Given I am on the Product Listing Page
    When I click on the Wishlist icon
    Then I see that Wishlist icon state is changed

#  Scenario: Checking Wishlist after addind the product
#    Given I have added a product to the Wishlist
#    When I click on the Wishlist icon of a Product
#    Then I see the Wishlist Page with added Product