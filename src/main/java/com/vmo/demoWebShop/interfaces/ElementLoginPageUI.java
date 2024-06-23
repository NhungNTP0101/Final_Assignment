package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementLoginPageUI {
    public static final String EMAIL_LOCATOR = Locator.id("Email");
    public static final String PASSWORD_LOCATOR = Locator.id("Password");
    public static final String LOGIN_BTN_LOCATOR = Locator.className("login-button");
    public static final String DYNAMIC_ERROR_MESSAGE_LOCATOR = Locator.xpath("//li[contains(text(),'%s')]");
    public static final String DYNAMIC_ERROR_EMAIL_MESSAGE_LOCATOR = Locator.xpath("//span[contains(text(),'%s')]");
    public static final String CHECKOUT_AS_GUEST_BTN_LOCATOR = Locator.xpath("//input[@value='Checkout as Guest']");


}