package de.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.docstring.DocString;
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
        loginPage = page(LoginPage.class);
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

    @When("I insert {} and {}")
    public void iInsertInvalidUserCreds(String username, String password) {
        loginPage.invalidLoginInput(username,password);
    }
    @Then("I should see error message:")
    public void iShouldseeErrorMessage(DocString message){
        String errorMassage = message.getContent();
        SelenideElement pageMessage = loginPage.getValidationMessageElement();
        pageMessage.shouldHave(text(errorMassage));

    }
}
