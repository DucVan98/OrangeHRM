package testcases.CheckOut;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.AddressPage;
import pageobjects.CartPage;
import pageobjects.IndexPage;
import pageobjects.OrderSummary;
import testcases.CartPage.CartContractor;
import testcases.SearchPage.SearchResultPageTest;
import testcases.SignInPage.signContractor;

public class CheckOutWithBankTransferTest extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    public pageobjects.AddToCartPage AddToCartPage;
    public pageobjects.CartPage CartPage;
    public pageobjects.AddressPage AddressPage;
    public pageobjects.OrderSummary OrderSummary;
    public signContractor signInTest;
    public SearchResultPageTest searchPage;
    public testcases.AddToCart.AddToCartPageTest AddToCartPageTest;
    public CartContractor cartPage;


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1,description = "Kiểm tra checkout thành công khi chọn hình thức thanh toán là Bank transfer")
    public void CheckOutWithBank() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        AddressPage= new AddressPage(driver);
        signInTest = new signContractor(driver);
        OrderSummary = new OrderSummary(driver);
        //Kế thừa class test
        cartPage = new CartContractor(driver);
        cartPage.verifyTotalPrice();
        CartPage.clickOnProcessToCheckOut();
        Thread.sleep(1000);
        AddressPage.signIn();
        signInTest.signInFirst();
        Thread.sleep(1000);
        AddressPage.clickShippingMethod();
        Thread.sleep(1000);
        AddressPage.clickButtonBank();
        Thread.sleep(5000);
        AddressPage.clickCheckOut();
        Thread.sleep(1000);
        OrderSummary.verifyOrderSuccess();

    }
}
