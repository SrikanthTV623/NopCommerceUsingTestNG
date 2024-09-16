package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.pages.ItemsPage;
import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    LoginPage login;
    HomePage home;
    ItemsPage items;
    RegisterPage register;

    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        login = new LoginPage();
        home = new HomePage();
        items = new ItemsPage();
        register = new RegisterPage();
    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
