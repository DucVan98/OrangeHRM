package testcases.AddToCart;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

//@Listeners(TestListener.class)
public class AddToCartPageTest extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public SearchResultpage SearchResultpage;
    public AddToCartPage AddToCartPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1, description = "Kiểm tra thêm sản phẩm vào giỏ hàng thành công")
    public void AddToCartTest() throws Exception {
        IndexPage = new IndexPage(driver);
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "search");
        SearchResultpage = IndexPage.searchProduct(excel.getCellData("key", 1));
        Scoll(0, 200);
        AddToCartPage = SearchResultpage.clickOnProduct(excel.getCellData("product name", 1));
        Scoll(0, 50);
        AddToCartPage.enterQuality("2");
        AddToCartPage.clickAddToCart();
        Assert.assertTrue(AddToCartPage.checkAlert());
//        driver.close();
    }
    @Test(priority = 2, description = "Kiểm tra xóa sản phẩm vào giỏ hàng thành công")
    public void DeleteProductToCart() throws Exception {
        IndexPage = new IndexPage(driver);

    }
}
