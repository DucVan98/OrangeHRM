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

public class CheckOutWithBeforeLoginTest extends BaseClass {
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
    @Test(priority = 1,description = "Kiểm tra Checkout thành công khi đã login với tài khoản trước đó")
    public void CheckOutWithBeforeLoginTest() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        AddressPage= new AddressPage(driver);
        signInTest = new signContractor(driver);
        OrderSummary = new OrderSummary(driver);
        //Kế thừa class test
        cartPage = new CartContractor(driver);
        // đăng nhập
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "geust");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome("john.smith@botble.com","12345678");
        //tìm kiếm sản phẩm thêm vào giỏ hàng
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "search");
        SearchResultpage = IndexPage.searchProduct(excel.getCellData("key", 1));
        Scoll(0, 200);
        // Thêm sản phẩm vào giỏ hàng
        AddToCartPage = SearchResultpage.clickOnProduct(excel.getCellData("product name", 1));
        Scoll(0, 50);
        // Nhập số lượng
        AddToCartPage.enterQuality("2");
        AddToCartPage.clickAddToCart();
        //Hiển thị cart
        IndexPage.clickShowCart();
        Thread.sleep(1000);
        IndexPage.clickViewCart();
        //Click button checkout trong cart
        Thread.sleep(1000);
        CartPage.clickOnProcessToCheckOut();
        Thread.sleep(2000);
        AddressPage.clickShippingMethod();
        AddressPage.clickButtonCOD();
        Thread.sleep(3000);
        AddressPage.clickCheckOut();
        Thread.sleep(1000);
        OrderSummary.verifyOrderSuccess();

    }
}
