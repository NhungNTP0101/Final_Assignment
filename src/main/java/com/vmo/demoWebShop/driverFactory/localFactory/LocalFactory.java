package com.vmo.demoWebShop.driverFactory.localFactory;

import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriverManagement().getBrowserDriver();
                break;
            case "H_CHROME":
                driver = new ChormeHeadlessDriverManagement().getBrowserDriver();
                break;
            case "FIRE_FOX":
                driver = new FireFoxDriverManagement().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManagement().getBrowserDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported: " + browser);
        }
        return driver;
    }
}
