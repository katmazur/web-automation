package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import de.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class ProductsListPage {
    /* Properties */

    public static String PLPURL = PropertiesLoader.loadProperty("url") + "/kleiderschraenke";

    /* Elements */
    private static By wishlistBtn = By.cssSelector(".wishlistIcon");
    private static By wishListStatus = By.className("headerElement__status--wishlist");
    private static By loginButton = By.id("addToWishlistLoginBox");

    public void clickWishlistBtn() {
        $(wishlistBtn).click();
    }

    public SelenideElement getWishlistCounterElement() {
        return $(wishListStatus);
    }

    public int getWishlistCount() {
        return Integer.parseInt(getWishlistCounterElement().getText());
    }
    public SelenideElement getLoginButton(){
        return $(loginButton);
    }
    public void clickLoginBtnAtRequestForm() {
        $(loginButton).click();
    }

}
