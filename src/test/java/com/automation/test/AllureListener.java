package com.automation.test;

import com.automation.utils.AllureReportManager;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

public class AllureListener extends AllureTestNg {

    @Override
    public void onTestFailure(ITestResult result){
        AllureReportManager.attachScreenshot();
        AllureReportManager.attachLog("failed statement");
        super.onTestFailure(result);
    }
}
