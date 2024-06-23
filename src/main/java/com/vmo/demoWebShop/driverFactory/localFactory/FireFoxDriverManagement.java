package com.vmo.demoWebShop.driverFactory.localFactory;

import com.vmo.demoWebShop.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver();
    }
}
