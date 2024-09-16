package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement searchBar;

    public void openWebsite(){
        driver.get("https://demo.nopcommerce.com/");
    }

    public Boolean isHomePageDisplayed(){
        return searchBar.isDisplayed();
    }

    public void searchForItem(String item1){
        searchBar.sendKeys(item1);
    }
}
