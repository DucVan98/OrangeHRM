package testcases.CheckOut;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;
import testcases.AddToCart.AddToCartPageTest;
import testcases.CartPage.CartContractor;
import testcases.SearchPage.SearchResultPageTest;
import testcases.SignInPage.signContractor;

//@Listeners(TestListener.class)
public class CheckOutWithAfterLoginTest extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public SearchResultpage SearchResultpage;
    public AddToCartPage AddToCartPage;
    public CartPage CartPage;
    public AddressPage AddressPage;
    public OrderSummary OrderSummary;
    public signContractor signInTest;
    public SearchResultPageTest searchPage;
    public AddToCartPageTest AddToCartPageTest;
    public CartContractor cartPage;


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1,description = "Kiểm tra checkout thành công khi cho button login tại màn hình shipping infomation")
    public void CheckOutAfterLoginTest() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        AddressPage= new AddressPage(driver);
        OrderSummary = new OrderSummary(driver);
        signInTest = new signContractor(driver);
        cartPage = new CartContractor(driver);
// Steps
        cartPage.verifyTotalPrice();
        CartPage.clickOnProcessToCheckOut();
        Thread.sleep(1000);
        AddressPage.signIn();
        signInTest.signInFirst();
        Thread.sleep(1000);
        AddressPage.clickShippingMethod();
        AddressPage.clickButtonCOD();
        Thread.sleep(3000);
        AddressPage.clickCheckOut();
//        Thread.sleep(1000);
        OrderSummary.verifyOrderSuccess();

    }
}
