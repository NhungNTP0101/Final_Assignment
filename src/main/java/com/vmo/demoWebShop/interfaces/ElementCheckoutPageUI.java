package com.vmo.demoWebShop.interfaces;

import com.vmo.demoWebShop.common.Locator;

public class ElementCheckoutPageUI {
    public static final String FIRST_NAME_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_FirstName");
    public static final String LAST_NAME_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_LastName");
    public static final String EMAIL_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_Email");
    public static final String COMPANY_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_Company");
    public static final String COUNTRY_DROPOUT_LOCATOR = Locator.id("BillingNewAddress_CountryId");
    public static final String CITY_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_City");
    public static final String ADDRESS1_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_Address1");
    public static final String ADDRESS2_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_Address2");
    public static final String ZIP_POSTAL_CODE_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_ZipPostalCode");
    public static final String PHONE_NUMBER_TEXTBOX_LOCATOR = Locator.id("BillingNewAddress_PhoneNumber");
    public static final String CONTINUE_TO_SAVE_BILLING_BTN_LOCATOR = Locator.xpath("//input[@onclick='Billing.save()']");
    public static final String CONTINUE_TO_SAVE_PAYMENT_METHOD_BTN_LOCATOR = Locator.xpath("//input[@onclick='PaymentMethod.save()']");
    public static final String CONTINUE_TO_SAVE_PAYMENT_INFO_BTN_LOCATOR = Locator.xpath("//input[@onclick='PaymentInfo.save()']");
    public static final String CONFIRM_BTN_LOCATOR = Locator.xpath("//input[@onclick='ConfirmOrder.save()']");
    public static final String CONTINUE_BTN_LOCATOR = Locator.xpath("//input[@class='button-2 order-completed-continue-button']");
}
