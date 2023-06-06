package testcases.HomePage;

import base.BaseClass;
import utils.listeners.ReportListener;
import utils.listeners.TestListener;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.SearchResultpage;
import pageobjects.SigninPage;
import pageobjects.AddToCartPage;
import pageobjects.AddressPage;

import java.lang.reflect.Method;

//@Listeners(ReportListener.class)
public class IndexPageTest extends BaseClass {
    private WebDriver driver;
    public IndexPage IndexPage;
    public SigninPage SigninPage;
    public AddToCartPage AddToCartPage;
    public SearchResultpage SearchResultpage;
    public AddressPage AddressPage;
    String expectedTitle = "OrangenHRM - Laravel Ecommerce system";
    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    //case :verifyLogoPage kiểm tra xem có tìm thấy đúng logo hay không.
    @Test (priority = 1)
    public void verifyLogoPage(Method result) throws Exception {
        IndexPage = new IndexPage(driver);
        boolean actual = IndexPage.validateLogo();
        System.out.println("verifyLogoPage : Pass");
        Assert.assertTrue(actual,"Fail");
    }
    @Test (priority = 2)
    public void verifyURL() throws Exception {
        String StoreTitle = IndexPage.getUrl();
        String expect = "http://localhost/orangehrm/public/";
        Assert.assertEquals(StoreTitle, expect);
    }
}
