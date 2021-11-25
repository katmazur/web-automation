package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    /* Properties */
    private static String validEmail = PropertiesLoader.loadProperty("valid.email");
    private static String validPwd = PropertiesLoader.loadProperty("valid.password");

    /* Elements */

    private static By emailInput = By.id("loginEmail");
    private static By pwdInput = By.id("loginPassword");
    private static By loginBtn = By.id("login-submit");
    private static By loginHeader = By.cssSelector(".existingAccount__headline");
    private static By usernameError = By.id("loginEmail-error");


    public void validLoginInput() {
        $(emailInput).setValue(validEmail);
        $(pwdInput).setValue(validPwd);
    }

    public void invalidLoginInput(String username, String password) {
        $(emailInput).setValue(username);
        $(pwdInput).setValue(password);
    }

    public void clickLoginBtn() {
        $(loginBtn).click();
    }

    public SelenideElement loginPageHeader() {
        return $(loginHeader);
    }

    public SelenideElement getValidationMessageElement() {
        return $(usernameError);


    }

}
