package com.automation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;


public class AllureReportManager {

    public static void attachScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot",new ByteArrayInputStream(screenshot));
    }


    public static void attachLog(String message){
        Allure.addAttachment("log",message);
    }
}
