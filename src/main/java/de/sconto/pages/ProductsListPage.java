package de.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
    private static By loginButton = By.cssSelector(".fancybox-container #addToWishlistLoginBox");

    public String lastClickedProdId;

    public void clickWishlistBtn() {
        SelenideElement el = $(".articleTile");
        lastClickedProdId = el.attr("data-article-number");
        el.find(wishlistBtn).click();
    }

    public SelenideElement getWishlistCounterElement() {
        return $(wishListStatus);
    }

    public int getWishlistCount() {
        return Integer.parseInt(getWishlistCounterElement().getText());
    }

    public SelenideElement getLoginButton() {
        return $(loginButton);
    }

    public void clickLoginBtnAtRequestForm() {
        $(loginButton).shouldBe(Condition.visible);
        Selenide.sleep(3000);
        $(loginButton).click();
    }

}
