package testcases;

import base.BaseClass;
import utils.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.IndexPage;
import pageobjects.SearchResultpage;
import pageobjects.SigninPage;
import pageobjects.MyAccoutPage;

//@Listeners(TestListener.class)
public class MyAccoutPageTest extends BaseClass {
    private WebDriver driver;
    public IndexPage IndexPage;
    public SigninPage SigninPage;
    public AddToCartPage AddToCartPage;
    public SearchResultpage SearchResultpage;
    public MyAccoutPage MyAccoutPage;
    String expectedTitle = "OrangenHRM - Laravel Ecommerce system";
    @BeforeClass
    public void setUp() throws Exception {
        driver = getDriver();
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        MyAccoutPage = new MyAccoutPage(driver);
        Thread.sleep(1000);
        Assert.assertTrue(SigninPage.verifyPageTitle(), "Header page text not matching");
        Scoll(0,50);
        IndexPage = SigninPage.signingHome("john.smith@botble.com", "12345678");
        Assert.assertTrue(IndexPage.verifyLogin());
        Thread.sleep(1000);
//        IndexPage.clickMyAccountButton();
    }
    @Test(priority = 1)
    public void verifyPagetitle() throws Exception {
        IndexPage = new IndexPage(driver);
        MyAccoutPage = new MyAccoutPage(driver);
        IndexPage.clickMyAccountButton();
        Thread.sleep(1000);
        String pageTile = "Account information";
//        System.out.println("getpage title : " +MyAccoutPage.getPagetitle());
        Assert.assertEquals(pageTile, MyAccoutPage.getPagetitle());
        Scoll(0,50);
        System.out.println("verifyPagetitle : Pass");

    }
    @Test(priority = 2)
    public void verifyListOrders() throws Exception {
        MyAccoutPage = new MyAccoutPage(driver);
        Thread.sleep(1000);
        String getHref = MyAccoutPage.gotoListOrderPage();
        Thread.sleep(1000);
        String listOrderURL = "http://localhost/orangehrm/public/customer/orders";
        Assert.assertEquals(getHref,listOrderURL);
        System.out.println("verifyListOrders : Pass");
    }
    @Test(priority = 3)
    public void verifyDownloads() throws Exception {
        Thread.sleep(1000);
        MyAccoutPage = new MyAccoutPage(driver);
        Thread.sleep(2000);
        String getHref = MyAccoutPage.gotodownloadsPage();
        Thread.sleep(1000);
        String DowloadURL = "http://localhost/orangehrm/public/customer/downloads";
        Assert.assertEquals(getHref,DowloadURL);
        System.out.println("verifyDownloads : Pass");
    }
    @Test(priority = 4)
    public void verifyOrderReturns() throws Exception {
        Thread.sleep(1000);

        MyAccoutPage = new MyAccoutPage(driver);
        Thread.sleep(2000);
        String getHref = MyAccoutPage.gotoOrderReturnRequestPage();
        Thread.sleep(1000);
        String verifyOrderReturnsURl = "http://localhost/orangehrm/public/customer/order-returns";
        Assert.assertEquals(getHref,verifyOrderReturnsURl);
        System.out.println("verifyOrderReturns : Pass");
    }
    @Test(priority = 5)
    public void verifyChangePassWord() throws Exception {
        Thread.sleep(1000);

        MyAccoutPage = new MyAccoutPage(driver);
        Scoll(0,150);
        Thread.sleep(1000);
        String getHref = MyAccoutPage.gotochangePassWordPage();
        Thread.sleep(1000);
        String changePassWordURl = "http://localhost/orangehrm/public/customer/change-password";
        Assert.assertEquals(getHref,changePassWordURl);
        System.out.println("verifyChangePassWord : Pass");
    }
    @Test(priority = 6)
    public void verifyaccountDetail() throws Exception {
        MyAccoutPage = new MyAccoutPage(driver);
        Scoll(0,150);
        Thread.sleep(1000);
        String getHref = MyAccoutPage.gotoaccountDetailPage();
        Thread.sleep(1000);
        String accountDetailURl = "http://localhost/orangehrm/public/customer/edit-account";
        Assert.assertEquals(getHref,accountDetailURl);
        System.out.println("verifyaccountDetail : Pass");
    }
    @Test(priority = 7)
    public void verifyMyAddress() throws Exception {
        MyAccoutPage = new MyAccoutPage(driver);
        Scoll(0,150);
        Thread.sleep(1000);
        String getHref = MyAccoutPage.gotoMyAddressPage();
        Thread.sleep(1000);
        String MyAddressURl = "http://localhost/orangehrm/public/customer/address";
        Assert.assertEquals(getHref,MyAddressURl);
        System.out.println("verifyMyAddress : Pass");
    }
    @Test(priority = 8)
    public void verifylogOut() throws Exception {
        MyAccoutPage = new MyAccoutPage(driver);
        Scoll(0,150);
        Thread.sleep(1000);
        String getHref = MyAccoutPage.gotologOut();
        Thread.sleep(1000);
        String logOutURl = "http://localhost/orangehrm/public/customer/logout";
        Assert.assertEquals(getHref,logOutURl);
        System.out.println("verifylogOut : Pass");
    }

}
