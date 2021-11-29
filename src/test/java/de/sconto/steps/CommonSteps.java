package de.sconto.steps;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class CommonSteps {
    @Before
    public void beforeTest(){
        clearBrowserCookies();
        clearBrowserCache();
    }

    @After
    public void quitBrowser(){
        Selenide.closeWebDriver();
    }
}
