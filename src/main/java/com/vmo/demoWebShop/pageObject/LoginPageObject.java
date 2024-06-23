package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.common.GlobalConstants;
import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.interfaces.ElementHomePageUI;
import com.vmo.demoWebShop.interfaces.ElementLoginPageUI;
import com.vmo.demoWebShop.utils.ExcelConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Epic("Demo Web Shop")
@Feature("Login")
@Story("Login with email and password")

public class LoginPageObject extends BasePage {
    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInValidEmailPassword() {
        Log.allure("Step: Fill in Valid Email and Password");
        ExcelConfig Ex = new ExcelConfig();
        waitForAllElementsVisible(driver, ElementLoginPageUI.EMAIL_LOCATOR);
        clickToElement(driver, ElementLoginPageUI.EMAIL_LOCATOR);
        sendKeyToElement(driver, ElementLoginPageUI.EMAIL_LOCATOR, Ex.getDataValue(1, 1));
        clickToElement(driver, ElementLoginPageUI.PASSWORD_LOCATOR);
        sendKeyToElement(driver, ElementLoginPageUI.PASSWORD_LOCATOR, Ex.getDataValue(1, 2));
        clickToElement(driver, ElementLoginPageUI.LOGIN_BTN_LOCATOR);
    }

    public void fillInInvalidEmailPassword() {
        Log.allure("Step: Fill in Invalid Email and Password");
        ExcelConfig Ex = new ExcelConfig();
        waitForAllElementsVisible(driver, ElementLoginPageUI.EMAIL_LOCATOR);
        for (int i = 2; i <= 6; i++) {
            clickToElement(driver, ElementLoginPageUI.EMAIL_LOCATOR);
            sendKeyToElement(driver, ElementLoginPageUI.EMAIL_LOCATOR, Ex.getDataValue(i, 1));
            clickToElement(driver, ElementLoginPageUI.PASSWORD_LOCATOR);
            sendKeyToElement(driver, ElementLoginPageUI.PASSWORD_LOCATOR, Ex.getDataValue(i, 2));
            clickToElement(driver, ElementLoginPageUI.LOGIN_BTN_LOCATOR);
            if (i<6) {
                isElementDisplay(driver, ElementLoginPageUI.DYNAMIC_ERROR_MESSAGE_LOCATOR,Ex.getDataValue(i, 3));
            }
            else {
                isElementDisplay(driver, ElementLoginPageUI.DYNAMIC_ERROR_EMAIL_MESSAGE_LOCATOR, Ex.getDataValue(i, 3));
            }
            System.out.println(Ex.getDataValue(i, 3));
            ;

        }

    }
    public void clickOnCheckoutAsGuestBtn() {
        Log.allure("Step: Click on Checkout button");
        clickToElement(driver, ElementLoginPageUI.CHECKOUT_AS_GUEST_BTN_LOCATOR);
        Assert.assertEquals(getTitle(driver),"Demo Web Shop. Checkout");
    }

}
