package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementBooksPageUI {
    public static final String ADD_TO_CART_BTN_LOCATOR = Locator.xpath("//div[@style='%s']/ancestor::div[@class='details']/div[@class='add-info']//input[@value='Add to cart']");
    public static final String RATING_LOCATOR = Locator.xpath("//input[@value='Add to cart']/ancestor::div[@class='details']/div[@class='product-rating-box']//div[contains(@style,'width')]");
    public static final String CART_LOCATOR = Locator.xpath("//span[contains(text(),'Shopping cart')]");
    public static final String PRODUCT_NAME_IN_LIST_LOCATOR = Locator.xpath("//div[@style='%s']//ancestor::div[@class='details']/h2/a");
    public static final String PRODUCT_NAME_IN_CART_LOCATOR = Locator.xpath("//div[@class='name']/a");}