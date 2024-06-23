package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.interfaces.ElementCartPageUI;
import com.vmo.demoWebShop.interfaces.ElementCheckoutPageUI;
import com.vmo.demoWebShop.interfaces.ElementHomePageUI;
import com.vmo.demoWebShop.interfaces.ElementLoginPageUI;
import com.vmo.demoWebShop.utils.ExcelConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Epic("Demo Web Shop")
@Feature("Login")
@Story("Login with email and password")

public class CartPageObject extends BasePage {
    private final WebDriver driver;

    public CartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItemFromCart() {
        Log.allure("Step: Remove Item from cart");
        waitForAllElementsVisible(driver, ElementCartPageUI.CART_PAGE_LOCATOR);
        List<String> itemNameList = new ArrayList<String>();
        List<WebElement> itemNameListElement = getListWebElements(driver, ElementCartPageUI.CART_PAGE_LOCATOR);
        itemNameListElement.forEach((item) -> itemNameList.add(item.getText()));
        String removedItem = itemNameList.get(getRandomNumberInRange(0, itemNameList.size() - 1));
        clickToElement(driver, ElementCartPageUI.DYNAMIC_REMOVE_CHECKBOX_LOCATOR, removedItem);
        isElementSelected(driver, ElementCartPageUI.DYNAMIC_REMOVE_CHECKBOX_LOCATOR, removedItem);
        System.out.println("Removed item " + removedItem);

    }

    public void clickUpdateShoppingCart() {
        Log.allure("Step: Click Update shopping cart");
        clickToElement(driver, ElementCartPageUI.UPDATE_CART_BTN_LOCATOR);

    }

    public void verifyCartAfterRemoving() {
        Log.allure("Step: Verify Cart after removing item");
        List<String> itemNameList = new ArrayList<String>();
        List<WebElement> itemNameListElement = getListWebElements(driver, ElementCartPageUI.CART_PAGE_LOCATOR);
        itemNameListElement.forEach((item) -> itemNameList.add(item.getText()));
        Assert.assertEquals(2, itemNameList.size());

    }

    public void checkToTermOfService() {
        Log.allure("Step: Check to term of service");
        waitForAllElementsVisible(driver, ElementCartPageUI.CART_PAGE_LOCATOR);
        clickToElement(driver, ElementCartPageUI.TERM_OF_SERVICE_CHECKBOX_LOCATOR);
        isElementSelected(driver, ElementCartPageUI.TERM_OF_SERVICE_CHECKBOX_LOCATOR);
    }

    public void clickOnCheckoutBtn() {
        Log.allure("Step: Click on Checkout button");
        clickToElement(driver, ElementCartPageUI.CHECKOUT_BTN_LOCATOR);
        isElementDisplay(driver, ElementLoginPageUI.CHECKOUT_AS_GUEST_BTN_LOCATOR);
    }

}
