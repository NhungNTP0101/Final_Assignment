package com.vmo.demoWebShop.helper;

import com.vmo.demoWebShop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FileAttachment extends BaseTest{
    @Attachment()
    public  static byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
//    @Override
//    public void onTestFailure(ITestResult result) {
//        Log.info("---------- " + result.getName() + " FAILED test ----------");
//        Object testClass = result.getInstance();
//        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//        saveScreenShot(webDriver);
//    }


}
