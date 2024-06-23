package com.vmo.demoWebShop.driverFactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IBrowserFactory {
    WebDriver getBrowserDriver() throws MalformedURLException;
}
