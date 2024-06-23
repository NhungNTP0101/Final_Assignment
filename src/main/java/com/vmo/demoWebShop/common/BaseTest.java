package com.vmo.demoWebShop.common;

import com.vmo.demoWebShop.driverFactory.localFactory.LocalFactory;
import com.vmo.demoWebShop.driverFactory.remoteFactory.RemoteFactory;
import com.vmo.demoWebShop.helper.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.MalformedURLException;

@Listeners(TestListener.class)
public class BaseTest {
    private WebDriver driver;

    public WebDriver getBrowserDriver(String browser, String modeRun) throws MalformedURLException {
        switch (modeRun.toUpperCase()) {
            case "LOCAL":
                driver = new LocalFactory().createDriver(browser);
                break;
            case "REMOTE":
                driver = new RemoteFactory().createDriver(browser);
                break;
            default:
                throw new RuntimeException("The mode run is not supported: " + modeRun);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void cleanAllBrowsers() {
        String osName = System.getProperty("os.name");
        String driverName = driver.toString().toLowerCase();
        try {
            String cmd;
            if (driverName.contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                    executeCommand(cmd);
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /IM chrome.exe /T";
                    executeCommand(cmd);
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                    executeCommand(cmd);
                }
            }
            if (driverName.contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                    executeCommand(cmd);
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /IM firefox.exe /T";
                    executeCommand(cmd);
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                    executeCommand(cmd);
                }
            } else if (driverName.contains("safari")) {
                cmd = "pkill safaridriver";
                executeCommand(cmd);
            }
        } catch (Exception e) {
            System.err.println("e = " + e);
        }

    }

    private static void executeCommand(String cmd) throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }
}