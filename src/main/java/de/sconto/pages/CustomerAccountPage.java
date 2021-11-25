package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CustomerAccountPage {

    /* Elements */
    private static By title = By.cssSelector(".titleHeadline");

    public SelenideElement accountTitle() { return $(title); }
}
