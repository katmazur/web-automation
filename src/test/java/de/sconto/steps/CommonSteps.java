package de.sconto.steps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import de.sconto.pages.WishListPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class CommonSteps {
    LoginPage loginPage;
    HomePage homePage;
    WishListPage wishListPage;

    public CommonSteps() {
        loginPage = page(LoginPage.class);
        homePage = page(HomePage.class);
        wishListPage = page(WishListPage.class);
    }

    @Before
    public void beforeTest(){
        clearBrowserCookies();
        clearBrowserCache();
    }

    @After
    public void quitBrowser(){
        Selenide.closeWebDriver();
    }
    @Then("I see {string}")
    public void iSeePage(String pageName) {
        switch (pageName){
            case "WishListPage":
                wishListPage.wishListHeader().should(Condition.exist).shouldHave(text("Wunschliste"));
                break;
            case "LoginPage":
                loginPage.loginPageHeader().should(Condition.exist).shouldHave(text("Anmelden"));
                break;
        }
    }
}
