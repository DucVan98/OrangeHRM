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

public class AddToCartContractor extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    public pageobjects.AddToCartPage AddToCartPage;

    public AddToCartContractor(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
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
}
