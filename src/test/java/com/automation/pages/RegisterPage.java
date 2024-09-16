package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{

    @FindBy(className = "ico-register")
    WebElement registerBtnOnHomepage;

    @FindBy(tagName = "h1")
    WebElement registerText;

    @FindBy(xpath = "//input[@id=\"gender-male\"]")
    WebElement genderMale;
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='date-picker-wrapper']/select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDay;
    @FindBy(xpath = "//div[@class='date-picker-wrapper']/select[@name='DateOfBirthMonth']")
    WebElement monthOfBirthDay;
    @FindBy(xpath = "//div[@class='date-picker-wrapper']/select[@name='DateOfBirthYear']")
    WebElement yearOfBirthDay;
    @FindBy(xpath = "//input[@id=\"Email\"]")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement registeredCompletionTxt;

    @FindBy(xpath = "//div[@class='buttons']/a")
    WebElement continueButton;

    public void clickOnRegisterButtonOnHomePage(){
        registerBtnOnHomepage.click();
    }

    public String isRegisterPageDisplayed(){
        return registerText.getText();
    }

    public void enterPersonalDetails(){
        genderMale.click();
        firstName.sendKeys(ConfigReader.getConfigValue("firstname"));
        lastName.sendKeys(ConfigReader.getConfigValue("lastname"));
        Select select1 = new Select(dateOfBirthDay);
        select1.selectByValue(ConfigReader.getConfigValue("date"));
        Select select2 = new Select(monthOfBirthDay);
        select2.selectByValue(ConfigReader.getConfigValue("month"));
        Select select3 = new Select(yearOfBirthDay);
        select3.selectByValue(ConfigReader.getConfigValue("year"));
        emailId.sendKeys(ConfigReader.getConfigValue("email"));
    }

    public void fillPassword(){
        password.sendKeys(ConfigReader.getConfigValue("password"));
        confirmPassword.sendKeys(ConfigReader.getConfigValue("password"));
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public String userRegistered(){
        return registeredCompletionTxt.getText();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
