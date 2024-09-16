package com.automation.test;

import com.automation.pages.LoginPage;
import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test(priority = 1)
    public void userRegistersToWebsite(){
        home.openWebsite();
        register.clickOnRegisterButtonOnHomePage();
        Assert.assertEquals("Register",register.isRegisterPageDisplayed());
        register.enterPersonalDetails();
        register.fillPassword();
        register.clickOnRegisterButton();
        Assert.assertEquals("Your registration completed",
                register.userRegistered());
        register.clickOnContinueButton();
        home.isHomePageDisplayed();
    }

    @Test(priority = 2)
    public void userLoginToWebsite(){
        home.openWebsite();
        login.clicksOnLoginButton();
        Assert.assertEquals("Welcome, Please Sign In!",
                login.isLoginPageDisplayed());
        login.doLogin(ConfigReader.getConfigValue("email"),
                ConfigReader.getConfigValue("password"));
        login.clickOnLogOutButton();
    }

    @Test(dataProviderClass = LoginPage.class, dataProvider = "negativeLoginData")
    public void userLoginToWebsiteWithInvalidCredentials(String email,String password){
        home.openWebsite();
        login.clicksOnLoginButton();
        Assert.assertEquals("Welcome, Please Sign In!",
                login.isLoginPageDisplayed());
        login.doLoginForInvalid(email,password);
        login.clickOnLogOutButton();
    }

    @Test(priority = 3)
    public void verifyItemIsAddedIntoCart(){
        home.openWebsite();
        login.clicksOnLoginButton();
        login.doLogin(ConfigReader.getConfigValue("email"),
                ConfigReader.getConfigValue("password"));
        Assert.assertTrue(home.isHomePageDisplayed(),
                "Homepage is not loading properly");
        home.searchForItem(ConfigReader.getConfigValue("item1"));
        items.clickItemInItemsPage();
        items.addItem1ToCart();
        Assert.assertEquals("The product has been added to your shopping cart",
                items.verifyItemIsAddedToCart());
        login.clickOnLogOutButton();
    }

    @Test(priority = 4)
    public void verifyItemIsAddedToWishList(){
        home.openWebsite();
        login.clicksOnLoginButton();
        login.doLogin(ConfigReader.getConfigValue("email"),
                ConfigReader.getConfigValue("password"));
        Assert.assertTrue(home.isHomePageDisplayed(),
                "Homepage is not loading properly");
        home.searchForItem(ConfigReader.getConfigValue("item1"));
        items.clickItemInItemsPage();
        items.setAddToWishList();
        Assert.assertEquals("The product has been added to your wishlist",
                items.verifyItemAddedToWishList());
        login.clickOnLogOutButton();
    }
}
