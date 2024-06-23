package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementCartPageUI {
    public static final String CART_PAGE_LOCATOR = Locator.xpath("//td[@class='product']/a");
    public static final String DYNAMIC_REMOVE_CHECKBOX_LOCATOR = Locator.xpath("//a[text()='%s']/ancestor::tr[@class='cart-item-row']//input[@name='removefromcart']");
    public static final String UPDATE_CART_BTN_LOCATOR = Locator.xpath("//input[@value='Update shopping cart']");
    public static final String TERM_OF_SERVICE_CHECKBOX_LOCATOR = Locator.id("termsofservice");
    public static final String CHECKOUT_BTN_LOCATOR = Locator.id("checkout");


}