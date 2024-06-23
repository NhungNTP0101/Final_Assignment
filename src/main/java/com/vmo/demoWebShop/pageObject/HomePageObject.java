package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.common.GlobalConstants;
import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.interfaces.ElementHomePageUI;
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

public class HomePageObject extends BasePage {
    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openDemoWebShop() {
        Log.allure("Step: Open Demo Web Shop");
        openUrl(driver, GlobalConstants.URL_BASE);

    }

    public void verifyPageTitle(String title) {
        Log.allure("Step: Verify Title ", title);
        Assert.assertEquals(getTitle(driver), title);
    }

    public void clickOnLoginTag() {
        Log.allure("Step: Click on Login tag");
        waitForAllElementsVisible(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Log in");
        clickToElement(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Log in");
    }

    public void clickOnBooksTag() {
        Log.allure("Step: Click on Books tag");
        waitForAllElementsVisible(driver, ElementHomePageUI.DYNAMIC_TOP_MENU_LOCATOR, "Books");
        clickToElement(driver, ElementHomePageUI.DYNAMIC_TOP_MENU_LOCATOR, "Books");
    }

    public void clickOnLogoutBtn() {
        Log.allure("Step: Click Logout");
        waitForAllElementsVisible(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Log out");
        clickToElement(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Log out");
    }

    public void clickOnDigitalDownloads() {
        Log.allure("Step: Click on Digital downloads");
        waitForAllElementsVisible(driver, ElementHomePageUI.DYNAMIC_TOP_MENU_LOCATOR, "Digital downloads");
        clickToElement(driver, ElementHomePageUI.DYNAMIC_TOP_MENU_LOCATOR, "Digital downloads");
        Assert.assertEquals(getTitle(driver),"Demo Web Shop. Digital downloads");
    }


    public void add3ItemsInFeaturedToCart() throws InterruptedException {
        Log.allure("Step: Add 3 items in Featured to Cart");
        moveToElement(driver, ElementHomePageUI.FEATURED_PRODUCT_TITLE_LOCATOR);
        List<String> itemNameList = new ArrayList<String>();
        List<WebElement> itemNameListElement = getListWebElements(driver, ElementHomePageUI.ITEM_NAME_LIST_LOCATOR);
        itemNameListElement.forEach((item) -> itemNameList.add(item.getText()));
        for (int i = 0; i < 3; i++) {
            waitForAllElementsVisible(driver, ElementHomePageUI.FEATURED_PRODUCT_TITLE_LOCATOR);
            String name = itemNameList.get(getRandomNumberInRange(0, itemNameList.size() - 1));
            itemNameList.remove(name);
            clickToElement(driver, ElementHomePageUI.DYNAMIC_ITEM_NAME_LOCATOR, name);
            switch (name) {
                case "Build your own computer":
                    clickToElement(driver, ElementHomePageUI.HDD_LOCATOR);
                    clickToElement(driver, ElementHomePageUI.ADD_TO_CART_BTN_LOCATOR);
                    break;
                case "Simple Computer":
                    clickToElement(driver, ElementHomePageUI.PROCESSOR_LOCATOR);
                    clickToElement(driver, ElementHomePageUI.ADD_TO_CART_BTN_LOCATOR);
                    break;
                case "$25 Virtual Gift Card":
                    sendKeyToElement(driver, ElementHomePageUI.RECIPIENTS_NAME_LOCATOR, "Test");
                    sendKeyToElement(driver, ElementHomePageUI.RECIPIENTS_EMAIL_LOCATOR, "Test@gmail.com");
                    sendKeyToElement(driver, ElementHomePageUI.SENDER_NAME_LOCATOR, "Test");
                    sendKeyToElement(driver, ElementHomePageUI.SENDER_EMAIL_LOCATOR, "Testt@gmail.com");
                    clickToElement(driver, ElementHomePageUI.ADD_TO_CART_BTN_LOCATOR);
                    break;
                default:
                    clickToElement(driver, ElementHomePageUI.ADD_TO_CART_BTN_LOCATOR);
                    break;
            }
            waitForAllElementsVisible(driver,ElementHomePageUI.MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR);
            isElementDisplay(driver,ElementHomePageUI.MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR);
            System.out.println("Add item successfully: " + name);
            Thread.sleep(5000);
            backToPage(driver);

        }
    }

    public void clickOnShoppingCart() {
        Log.allure("Step: Click on Shopping cart");
        waitForAllElementsVisible(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Shopping cart");
        clickToElement(driver, ElementHomePageUI.DYNAMIC_HEADER_LINK_LOCATOR, "Shopping cart");
    }
}
