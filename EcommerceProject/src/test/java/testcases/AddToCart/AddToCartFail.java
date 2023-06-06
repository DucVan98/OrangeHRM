package testcases.AddToCart;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

public class AddToCartFail extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    public pageobjects.AddToCartPage AddToCartPage;


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1, description = "Kiểm tra thêm sản phẩm vào giỏ hàng không thành công")
    public void AddToCartFailTest() throws Exception {
        IndexPage = new IndexPage(driver);
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "search");
        SearchResultpage = IndexPage.searchProduct(excel.getCellData("key", 1));
        Scoll(0, 200);
        AddToCartPage = SearchResultpage.clickOnProduct(excel.getCellData("product name", 1));
        Scoll(0, 50);
        AddToCartPage.enterQuality(excel.getCellData("qty", 2));
        AddToCartPage.clickAddToCart();
        Assert.assertTrue(AddToCartPage.checkAlertFail());
//        driver.close();
    }
}
