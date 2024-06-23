package com.vmo.demoWebShop.pageObject;

import com.vmo.demoWebShop.common.BasePage;
import com.vmo.demoWebShop.helper.Log;
import com.vmo.demoWebShop.interfaces.ElementBooksPageUI;
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

public class BooksPageObject extends BasePage {
    private final WebDriver driver;

    public BooksPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void add2BooksHighestRated() throws InterruptedException {
        Log.allure("Step: Buy 2 books highest rated");
        List<String> rateList = new ArrayList<String>();
        List<WebElement> rateListElement = getListWebElements(driver, ElementBooksPageUI.RATING_LOCATOR);
        rateListElement.forEach((item) -> rateList.add(item.getAttribute("style")));
        rateList.sort((a, b) -> {
            float a1 = Float.parseFloat(b.split(" ")[1].substring(0, 2));
            float b1 = Float.parseFloat(a.split(" ")[1].substring(0, 2));
            return Float.compare(a1, b1);
        });

        System.out.println("After sorting: " + rateList);
        for (int i = 0; i < 2; i++) {
            String rate = rateList.get(i).substring(0, rateList.get(i).length() - 1);
            clickToElement(driver, ElementBooksPageUI.ADD_TO_CART_BTN_LOCATOR, rate);
            Thread.sleep(5000);
        }
    }

    public void hoverToCartAndVerifyResult() {
        Log.allure("Step: Hover on Shopping cart and Verify result");
        scrollToHeaderPage(driver);
        moveToElement(driver, ElementBooksPageUI.CART_LOCATOR);
        List<String> rateList = new ArrayList<String>();
        List<WebElement> rateListElement = getListWebElements(driver, ElementBooksPageUI.RATING_LOCATOR);
        rateListElement.forEach((item) -> rateList.add(item.getAttribute("style")));
        rateList.sort((a, b) -> {
            float a1 = Float.parseFloat(b.split(" ")[1].substring(0, 2));
            float b1 = Float.parseFloat(a.split(" ")[1].substring(0, 2));
            return Float.compare(a1, b1);
        });

        List<String> productList = new ArrayList<String>();
        List<WebElement> productElement = getListWebElements(driver, ElementBooksPageUI.PRODUCT_NAME_IN_CART_LOCATOR);
        productElement.forEach((item) -> productList.add(item.getText()));
        System.out.println(productList);

        for (int i = 0; i < 2; i++) {
            String rate = rateList.get(i).substring(0, rateList.get(i).length() - 1);
            String itemNameInList = getTextElement(driver, ElementBooksPageUI.PRODUCT_NAME_IN_LIST_LOCATOR, rate);
            String itemNameInCart = productList.get(productList.size()-1-i);
            Assert.assertEquals(itemNameInList, itemNameInCart);

        }
    }
}