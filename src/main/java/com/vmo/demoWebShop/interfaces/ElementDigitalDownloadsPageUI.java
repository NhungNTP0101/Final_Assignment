package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementDigitalDownloadsPageUI {
    public static final String PRODUCT_NAME_IN_LIST_LOCATOR = Locator.xpath("//h2[@class='product-title']/a");
    public static final String DYNAMIC_ADD_TO_CART_BTN_LOCATOR = Locator.xpath("//h2[@class='product-title']/a[text()='%s']/ancestor::div[@class='product-item']//input");
    public static final String MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR = Locator.xpath("//p[@class='content']");


}