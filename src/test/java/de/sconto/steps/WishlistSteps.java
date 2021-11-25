package de.sconto.steps;

import de.sconto.pages.ProductsListPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static de.sconto.pages.ProductsListPage.PLPURL;

//Then I see the Wishlist Page with added Product

public class WishlistSteps {
    ProductsListPage productsListPage;

    int wishlistCount;

    @Given("I am on the Product Listing Page")
    public void iAmOnProductsListPage() {
        productsListPage = open(PLPURL, ProductsListPage.class);
        wishlistCount = productsListPage.getWishlistCount();
    }
    @When("I click on the Wishlist icon")
    public void iClickOnWishlist() {
        productsListPage.clickWishlistBtn();
    }
    @Then("I see that Wishlist icon state is changed")
    public void iSeeWishListIconChanged(){
        productsListPage.getWishlistCounterElement().shouldHave(text(String.valueOf(wishlistCount+1)));
    }
    @After("@needCleanup")
    public void cleanUp() {
        productsListPage.clickWishlistBtn();
    }
}
