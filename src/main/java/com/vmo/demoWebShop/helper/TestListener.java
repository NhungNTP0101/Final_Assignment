package com.vmo.demoWebShop.helper;

import com.vmo.demoWebShop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Attachment()
    public  static void saveScreenShot(WebDriver driver){
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onTestStart(ITestResult result) {
        System.out.println("---------Test start-----------");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("---------Test success-----------");
        Log.info("---------- " + result.getName() + " PASS test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);;
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("---------Test failure-----------");
        Log.info("---------- " + result.getName() + " FAIL test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);;
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("---------Test skip-----------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        System.out.println("---------Test finish-----------");
    }


}
