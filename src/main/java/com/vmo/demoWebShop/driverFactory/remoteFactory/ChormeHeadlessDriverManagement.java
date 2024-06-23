package com.vmo.demoWebShop.driverFactory.remoteFactory;

import com.vmo.demoWebShop.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChormeHeadlessDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        return new RemoteWebDriver(new URL("http://localhost:4444"), options);
    }
}
