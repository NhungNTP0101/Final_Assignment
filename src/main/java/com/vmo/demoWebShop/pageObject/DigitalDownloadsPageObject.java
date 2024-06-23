package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.interfaces.ElementCartPageUI;
import com.vmo.demoWebShop.interfaces.ElementDigitalDownloadsPageUI;
import com.vmo.demoWebShop.interfaces.ElementHomePageUI;
import com.vmo.demoWebShop.interfaces.ElementLoginPageUI;
import com.vmo.demoWebShop.utils.ExcelConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Epic("Demo Web Shop")
@Feature("Login")
@Story("Login with email and password")

public class DigitalDownloadsPageObject extends BasePage {
    private final WebDriver driver;

    public DigitalDownloadsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void AddAnItemToCart() {
        Log.allure("Step: Add an item to cart");
        List<String> itemNameList = new ArrayList<String>();
        List<WebElement> itemNameListElement = getListWebElements(driver, ElementDigitalDownloadsPageUI.PRODUCT_NAME_IN_LIST_LOCATOR);
        itemNameListElement.forEach((item) -> itemNameList.add(item.getText()));
        String name = itemNameList.get(getRandomNumberInRange(0, itemNameList.size() - 1));
        clickToElement(driver, ElementDigitalDownloadsPageUI.DYNAMIC_ADD_TO_CART_BTN_LOCATOR,name);
        waitForAllElementsVisible(driver, ElementDigitalDownloadsPageUI.MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR);
        isElementDisplay(driver,ElementDigitalDownloadsPageUI.MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR);
        System.out.println("Add item successfully: " + name);
    }

}
