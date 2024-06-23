package com.vmo.demoWebShop.driverFactory.remoteFactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class RemoteFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) throws MalformedURLException {
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
