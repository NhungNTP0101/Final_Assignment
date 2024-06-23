package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementHomePageUI {
    public static final String DYNAMIC_HEADER_LINK_LOCATOR = Locator.xpath("//a[contains(text(),'%s')]");
    public static final String DYNAMIC_TOP_MENU_LOCATOR = Locator.xpath("//ul[@class='top-menu']//a[contains(text(),'%s')]");
    public static final String FEATURED_PRODUCT_TITLE_LOCATOR = Locator.xpath("//strong[text()='Featured products']");
    public static final String ITEM_NAME_LIST_LOCATOR = Locator.xpath("//input[@value='Add to cart']/ancestor::div[@class='details']/h2[@class='product-title']/a");
    public static final String DYNAMIC_ITEM_NAME_LOCATOR = Locator.xpath("//a[text()='%s']");
    public static final String ADD_TO_CART_BTN_LOCATOR = Locator.xpath("//input[@class='button-1 add-to-cart-button']");
    public static final String HDD_LOCATOR = Locator.id("product_attribute_16_3_6_18");
    public static final String PROCESSOR_LOCATOR = Locator.id("product_attribute_75_5_31_96");
    public static final String RECIPIENTS_NAME_LOCATOR = Locator.className("recipient-name");
    public static final String RECIPIENTS_EMAIL_LOCATOR = Locator.className("recipient-email");
    public static final String SENDER_NAME_LOCATOR = Locator.className("sender-name");
    public static final String SENDER_EMAIL_LOCATOR = Locator.className("sender-email");
    public static final String MESSAGE_ADD_TO_CART_SUCCESSFULLY_LOCATOR = Locator.xpath("//p[@class='content']");



}