package de.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WishListPage {

    private static By WishListHeader = By.cssSelector(".headline wishlistOverview");
    private static By wishlistEntry  = By.cssSelector(".wishlistEntry");


    public SelenideElement wishListHeader() {
        return $(WishListHeader);
    }
    public SelenideElement wishlistEntry(){
        return $(wishlistEntry);
    }
}
