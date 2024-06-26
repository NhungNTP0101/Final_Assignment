package com.vmo.demoWebShop.driverFactory.localFactory;

import com.vmo.demoWebShop.driverFactory.IBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManagement implements IBrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        return new EdgeDriver();
    }
}
