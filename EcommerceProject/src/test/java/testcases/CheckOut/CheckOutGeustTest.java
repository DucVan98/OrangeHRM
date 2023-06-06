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

public class CheckOutGeustTest extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    public pageobjects.AddToCartPage AddToCartPage;
    public CartPage CartPage;
    public AddressPage AddressPage;
    public OrderSummary OrderSummary;
    public signContractor signInTest;
    public SearchResultPageTest searchPage;
    public testcases.AddToCart.AddToCartPageTest AddToCartPageTest;
    public CartContractor cartPage;


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1,description = "Kiểm tra checkout thành công bằng hình thức nhập thông tin giao hàng")
    public void CheckOutWithGuest() throws Exception {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "geust");
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        AddressPage= new AddressPage(driver);
        signInTest = new signContractor(driver);
        OrderSummary = new OrderSummary(driver);
        cartPage = new CartContractor(driver);
        // Steps
        cartPage.verifyTotalPrice();
        CartPage.clickOnProcessToCheckOut();
        Thread.sleep(1000);
        AddressPage.geustCheckOutGeust(
                excel.getCellData("fullname", 1),
                excel.getCellData("email", 1),
                excel.getCellData("phone", 1),
                excel.getCellData("country", 1),
                excel.getCellData("state", 1),
                excel.getCellData("city", 1),
                excel.getCellData("address", 1)
        );
        AddressPage.clickCheckBoxCreateAccount();
        AddressPage.accoutNew("12345678","12345678");
        Thread.sleep(5000);
        AddressPage.clickCheckOut();
        Thread.sleep(1000);
        OrderSummary.verifyOrderSuccess();

    }
}
