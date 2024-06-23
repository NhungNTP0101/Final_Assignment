package com.vmo.demoWebShop.driverFactory.remoteFactory;

import com.vmo.demoWebShop.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        return new RemoteWebDriver(new URL("http://localhost:4444"), options);
    }
}
