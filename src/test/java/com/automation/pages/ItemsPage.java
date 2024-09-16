package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemsPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @FindBy(xpath = "//h2[@class='product-title']/a[contains(text(),'HTC One M8 Android L 5.0 Lollipop')]")
    //@FindBy(xpath = "//div[@class='item-grid']/div[1]//h2/a")
    WebElement clickItem1;

    @FindBy(xpath = "//button[@id=\"add-to-cart-button-18\"]")
    WebElement addToCart;

    @FindBy(xpath = "//p[@class='content']")
    WebElement addToCartTxt;

    @FindBy(xpath = "//button[@id='add-to-wishlist-button-18']")
    WebElement addToWishList;

    @FindBy(xpath = "//p[@class='content']")
    WebElement wishListTxt;

    public void clickItemInItemsPage(){
        clickItem1.click();
    }
    public void addItem1ToCart(){
        addToCart.click();
    }

    public String verifyItemIsAddedToCart(){
        return addToCartTxt.getText();
    }

    public void setAddToWishList(){
        addToWishList.click();
    }

    public String verifyItemAddedToWishList(){
        return wishListTxt.getText();
    }
}
