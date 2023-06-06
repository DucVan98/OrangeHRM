package testcases.CartPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;

public class CartPageTestCoupo extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public SearchResultpage SearchResultpage;
    public AddToCartPage AddToCartPage;
    public CartPage CartPage;


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();

    }
    @Test(priority = 1, description = "Kiểm tra tổng tiền khi thêm mã Coupo")
    public void verifyTotalPriceAddCoupo() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "search");
        SearchResultpage = IndexPage.searchProduct(excel.getCellData("key", 1));
        Scoll(0, 200);
        AddToCartPage = SearchResultpage.clickOnProduct(excel.getCellData("product name", 1));
        Scoll(0, 50);
        AddToCartPage.enterQuality(excel.getCellData("qty", 1));
        AddToCartPage.clickAddToCart();
        Assert.assertTrue(AddToCartPage.checkAlert());
        IndexPage.clickShowCart();
        Thread.sleep(1000);
        IndexPage.clickViewCart();
        Thread.sleep(1000);
        Scoll(0,400);
        CartPage.enterCuopoCode("add");
        Double unitPrice = CartPage.getUnitPrice();
        Double totalPrice =CartPage.getTotalPriceCoupo();
        Double totalCoupo =CartPage.getTotalCoupo();
        Double tax = ((unitPrice*2)/100)*10;
        Double expected =(unitPrice*2)+tax-totalCoupo;
        Assert.assertEquals(expected,totalPrice,"Fail");
    }

}
