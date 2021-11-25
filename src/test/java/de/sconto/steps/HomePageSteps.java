package de.sconto.steps;

import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static de.sconto.pages.HomePage.basicURL;

/**
 * HomePageSteps
 * Class implements the Homepage step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HomePageSteps {
    HomePage homePage;

    @Given("I am on the Homepage")
    public void iAmOnHomePage() {
        homePage = open(basicURL, HomePage.class);
        homePage.acceptCookies();
    }

    @Then("I should see Homepage")
    public void iShouldSeeHomepage() {
        homePage.carousel().should(exist);
    }
}
