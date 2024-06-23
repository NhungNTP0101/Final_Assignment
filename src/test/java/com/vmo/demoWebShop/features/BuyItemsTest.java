package com.vmo.demoWebShop.features;

import com.vmo.demoWebShop.common.BaseTest;
import com.vmo.demoWebShop.pageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BuyItemsTest extends BaseTest {
    private WebDriver driver;
    private HomePageObject HomePageObject;
    private BooksPageObject BooksPageObject;
    private CartPageObject CartPageObject;
    private DigitalDownloadsPageObject DigitalDownloadsPageObject;
    private LoginPageObject LoginPageObject;
    private  CheckoutPageObject  CheckoutPageObject;


    @BeforeMethod
    @Parameters({"browser", "modeRun"})
    public void setUp(@Optional("CHROME") String browser, @Optional("LOCAL") String modeRun) throws MalformedURLException {
        driver = getBrowserDriver(browser, modeRun);
        driver.manage().window().maximize();
        HomePageObject = new HomePageObject(driver);
        BooksPageObject = new BooksPageObject(driver);
        CartPageObject = new CartPageObject(driver);
        DigitalDownloadsPageObject =new DigitalDownloadsPageObject(driver);
        LoginPageObject = new LoginPageObject(driver);
        CheckoutPageObject = new  CheckoutPageObject(driver);
    }

    @Test
    public void TC02_Buy2BooksHighestRated() throws InterruptedException {
        HomePageObject.openDemoWebShop();
        HomePageObject.verifyPageTitle("Demo Web Shop");
        HomePageObject.clickOnBooksTag();
        BooksPageObject.add2BooksHighestRated();
        BooksPageObject.hoverToCartAndVerifyResult();

    }

    @Test
    public void TC03_RemoveItemOutOfShoppingCart() throws InterruptedException {
        HomePageObject.openDemoWebShop();
        HomePageObject.verifyPageTitle("Demo Web Shop");
        HomePageObject.add3ItemsInFeaturedToCart();
        HomePageObject.clickOnShoppingCart();
        CartPageObject.removeItemFromCart();
        CartPageObject.clickUpdateShoppingCart();
        CartPageObject.verifyCartAfterRemoving();

    }
    @Test
    public void TC04_BuyItemSuccessfully() throws InterruptedException {
        HomePageObject.openDemoWebShop();
        HomePageObject.verifyPageTitle("Demo Web Shop");
        HomePageObject.clickOnDigitalDownloads();
        DigitalDownloadsPageObject.AddAnItemToCart();
        HomePageObject.clickOnShoppingCart();
        CartPageObject.checkToTermOfService();
        CartPageObject.clickOnCheckoutBtn();
        LoginPageObject.clickOnCheckoutAsGuestBtn();
        CheckoutPageObject.fillDataToCheckout();
        CheckoutPageObject.confirmPaymentMethod();
        CheckoutPageObject.confirmPaymentInfo();
        CheckoutPageObject.clickConfirmBtn();
        CheckoutPageObject.clickContinueBtn();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
