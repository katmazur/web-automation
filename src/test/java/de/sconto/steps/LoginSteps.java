package de.sconto.steps;

import com.codeborne.selenide.Condition;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

/**
 * LoginSteps
 * Class implements the Login page step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;

    @When("I click on the Login icon")
    public void iClickOnLoginIcon() {
        homePage = page(HomePage.class);
        loginPage = homePage.clickLoginIcon();
    }

    @Then("I see Login page")
    public void iSeeLoginPage() {
        loginPage.loginPageHeader().should(Condition.exist);
        loginPage.loginPageHeader().shouldHave(text("Anmelden"));
    }

    @When("I insert valid user credentials")
    public void iInsertUserCreds() {
        loginPage.validLoginInput();
    }

    @When("I click on Login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }
}
