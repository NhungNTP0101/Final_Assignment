package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.interfaces.ElementCheckoutPageUI;
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

public class CheckoutPageObject extends BasePage {
    private final WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDataToCheckout() {
        Log.allure("Step: Fill in data to checkout");
        sendKeyToElement(driver, ElementCheckoutPageUI.FIRST_NAME_TEXTBOX_LOCATOR, "TEST");
        sendKeyToElement(driver, ElementCheckoutPageUI.LAST_NAME_TEXTBOX_LOCATOR, "MINE");
        sendKeyToElement(driver, ElementCheckoutPageUI.EMAIL_TEXTBOX_LOCATOR, "Mine@gmail.com");
        sendKeyToElement(driver, ElementCheckoutPageUI.COMPANY_TEXTBOX_LOCATOR, "ABC");
        sendKeyToElement(driver, ElementCheckoutPageUI.COMPANY_TEXTBOX_LOCATOR, "ABC");
        selectItemInDefaultDropdownByText(driver, ElementCheckoutPageUI.COUNTRY_DROPOUT_LOCATOR, "United States");
        sendKeyToElement(driver, ElementCheckoutPageUI.CITY_TEXTBOX_LOCATOR, "CITY ABC");
        sendKeyToElement(driver, ElementCheckoutPageUI.ADDRESS1_TEXTBOX_LOCATOR, "ADDRESS 1 ABC");
        sendKeyToElement(driver, ElementCheckoutPageUI.ADDRESS2_TEXTBOX_LOCATOR, "ADDRESS 2 ABC");
        sendKeyToElement(driver, ElementCheckoutPageUI.ZIP_POSTAL_CODE_TEXTBOX_LOCATOR, "12124");
        sendKeyToElement(driver, ElementCheckoutPageUI.PHONE_NUMBER_TEXTBOX_LOCATOR, "097430334");
        clickToElement(driver, ElementCheckoutPageUI.CONTINUE_TO_SAVE_BILLING_BTN_LOCATOR);
    }

    public void confirmPaymentMethod() {
        waitForAllElementsVisible(driver, ElementCheckoutPageUI.CONTINUE_TO_SAVE_PAYMENT_METHOD_BTN_LOCATOR);
        clickToElement(driver, ElementCheckoutPageUI.CONTINUE_TO_SAVE_PAYMENT_METHOD_BTN_LOCATOR);
    }
    public void confirmPaymentInfo() {
        waitForAllElementsVisible(driver, ElementCheckoutPageUI.CONTINUE_TO_SAVE_PAYMENT_INFO_BTN_LOCATOR);
        clickToElement(driver, ElementCheckoutPageUI.CONTINUE_TO_SAVE_PAYMENT_INFO_BTN_LOCATOR);
        waitForAllElementsVisible(driver, ElementCheckoutPageUI.CONFIRM_BTN_LOCATOR);
        clickToElement(driver, ElementCheckoutPageUI.CONFIRM_BTN_LOCATOR);
    }

    public void clickConfirmBtn() {
        waitForAllElementsVisible(driver, ElementCheckoutPageUI.CONFIRM_BTN_LOCATOR);
        clickToElement(driver, ElementCheckoutPageUI.CONFIRM_BTN_LOCATOR);
    }

    public void clickContinueBtn() {
        waitForAllElementsVisible(driver, ElementCheckoutPageUI.CONTINUE_BTN_LOCATOR);
        clickToElement(driver, ElementCheckoutPageUI.CONTINUE_BTN_LOCATOR);
    }
}
