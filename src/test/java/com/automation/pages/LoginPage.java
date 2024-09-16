package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(className = "ico-login")
    WebElement loginBtnOnHomePage;

    @FindBy(tagName = "h1")
    WebElement signInTxt;

    @FindBy(id = "Email")
    WebElement enterEmail;
    @FindBy(id = "Password")
    WebElement enterPassword;
    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    WebElement loginButton;

    @FindBy(xpath = "//ul/li/a[text()='Log out']")
    WebElement logoutBtnOnHomePage;

    public void clicksOnLoginButton(){
        loginBtnOnHomePage.click();
    }

    public String isLoginPageDisplayed(){
        return signInTxt.getText();
    }

    public void doLogin(String email,String pass){
        enterEmail.sendKeys(email);
        enterPassword.sendKeys(pass);
        loginButton.click();
    }


    public void doLoginForInvalid(String email,String pass){
        enterEmail.sendKeys(email);
        enterPassword.sendKeys(pass);
        loginButton.click();
    }

    public void clickOnLogOutButton(){
        js.executeScript("arguments[0].click()",logoutBtnOnHomePage);
        //logoutBtnOnHomePage.click();
    }

    @DataProvider(name = "negativeLoginData")
    public static Object[][] negativeData(){
        return new Object[][] {
                {"kumarraj623@gmail.com", "raj456"},
                {"kumarraj623@gmail.com", "raj567"}
        };
    }


}
