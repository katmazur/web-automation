package de.sconto.steps;

import com.codeborne.selenide.Condition;
import de.sconto.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static de.sconto.pages.ProductsListPage.PLPURL;


public class WishlistSteps {
    ProductsListPage productsListPage;
    WishListPage wishListPage;
    LoginPage loginPage;
    CustomerAccountPage customerAccountPage;

    int wishlistCount;

    public WishlistSteps() {
        loginPage = page(LoginPage.class);
        wishListPage = page(WishListPage.class);
    }

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

    @Then("I see Login popup")
    public void iSeeLoginRequest() {
        productsListPage.getLoginButton().shouldBe(Condition.visible);
    }

    @When("When I click on Login button at Login popup")
    public void clickLoginAtRequestForm() {
        productsListPage.clickLoginBtnAtRequestForm();
    }


//    @And("I click on Login button at the Login Page")
//    public void iClickLoginButton() {
//        loginPage.clickLoginBtn();
//    }

    @Then("the product is added to the WishListPage")
    public void isProductAdded() {
        wishListPage.wishlistEntry().should(Condition.exist);
        wishListPage.wishlistEntry().shouldHave(Condition.attribute("data-wishlist-entry-id", productsListPage.lastClickedProdId));
    }

    @Then("I see that Wishlist icon state at the header is changed")
    public void iSeeWishListIconChanged() {
        productsListPage.getWishlistCounterElement().shouldHave(text(String.valueOf(wishlistCount + 1)));
    }

}
