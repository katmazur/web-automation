package de.sconto.steps;

import com.codeborne.selenide.Condition;
import de.sconto.pages.CustomerAccountPage;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

/**
 * CustomerAccountSteps
 * Class implements the Customer Account page step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class CustomerAccountSteps {

    CustomerAccountPage customerAccountPage;

        @Then("I should be logged in")
        public void shouldBeLoggedIn() {
            customerAccountPage = page(CustomerAccountPage.class);
            customerAccountPage.accountTitle().should(Condition.exist);
        }
}
