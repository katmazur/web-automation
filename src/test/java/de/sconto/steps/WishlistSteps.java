package de.sconto.steps;

import com.codeborne.selenide.Condition;
import de.sconto.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static de.sconto.pages.ProductsListPage.PLPURL;


public class WishlistSteps {
    ProductsListPage productsListPage;
    WishListPage wishListPage;
    LoginPage loginPage;
    CustomerAccountPage customerAccountPage;

    int wishlistCount;

    @Given("I am on the Product Listing Page")
    public void iAmOnProductsListPage() {
        productsListPage = open(PLPURL, ProductsListPage.class);
        HomePage hp = new HomePage();
        hp.acceptCookies();
        wishlistCount = productsListPage.getWishlistCount(); //separate step
    }

    @When("I click on the Wishlist icon")
    public void iClickOnWishlist() {
        productsListPage.clickWishlistBtn();
    }

    @Then("I see Login request form")
    public void iSeeLoginRequest() {
        productsListPage.getLoginButton().shouldBe(Condition.visible);


    }

    @When("I click on the Login button at the Login request form")
    public void clickLoginAtRequestForm(){
        productsListPage.clickLoginBtnAtRequestForm();
    }


    @And("I click on Login button at the Login Page")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("I should see WishListPage")
    public void iSeeLoginWishListPage(){
        wishListPage.wishListHeader().should(Condition.exist);
        wishListPage.wishListHeader().shouldHave(text("Wunschliste"));
    }
    @And("the product is added to the WishListPage")
    public void isProductAdded(){
        wishListPage.wishlistEntry().should(Condition.exist);
        wishListPage.wishListHeader().shouldHave(text("Kleiderschrank Base"));
    }
    @And("I see that Wishlist icon state at the header is changed")
    public void iSeeWishListIconChanged() {
        productsListPage.getWishlistCounterElement().shouldHave(text(String.valueOf(wishlistCount + 1)));
    }

}
