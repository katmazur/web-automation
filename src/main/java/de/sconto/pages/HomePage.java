package de.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * HomePage
 * Class implements the HomePage methods and fields.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HomePage {

    /* Properties */

    public static String basicURL = PropertiesLoader.loadProperty("url");

    /* Elements */

    private static By acceptBtn = By.xpath("//*[@data-accept-action='all']");
    private static By banner = By.cssSelector(".consentForm__title");
    private static By loginIcon = By.cssSelector(".headerElement--login");
    private static By carouselImg = By.className("headerElement__link--login");


    public void acceptCookies(){
        $(acceptBtn).click();
        $(banner).shouldNot(Condition.exist);
    }

    public LoginPage clickLoginIcon() {
        $(loginIcon).click();
        return Selenide.page(LoginPage.class);
    }

    public void hoverLoginIcon() {
        $(loginIcon).hover();
    }

    public SelenideElement carousel(){ return $(carouselImg); }
}
