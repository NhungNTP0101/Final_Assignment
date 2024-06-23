package com.vmo.demoWebShop.features;

import com.vmo.demoWebShop.common.BaseTest;
import com.vmo.demoWebShop.pageObject.HomePageObject;
import com.vmo.demoWebShop.pageObject.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static java.lang.Thread.sleep;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private HomePageObject HomePageObject;
    private LoginPageObject LoginPageObject;

    @BeforeMethod
    @Parameters({"browser", "modeRun"})
    public void setUp(@Optional("CHROME") String browser, @Optional("LOCAL") String modeRun) throws MalformedURLException {
        driver = getBrowserDriver(browser, modeRun);
        driver.manage().window().maximize();
        HomePageObject = new HomePageObject(driver);
        LoginPageObject = new LoginPageObject(driver);
    }

    @Test
    public void TC01_LoginSuccessfully() {
        HomePageObject.openDemoWebShop();
        HomePageObject.verifyPageTitle("Demo Web Shop");
        HomePageObject.clickOnLoginTag();
        LoginPageObject.fillInValidEmailPassword();
        HomePageObject.verifyPageTitle("Demo Web Shop");
        HomePageObject.clickOnLogoutBtn();
        HomePageObject.clickOnLoginTag();
        LoginPageObject.fillInInvalidEmailPassword();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
