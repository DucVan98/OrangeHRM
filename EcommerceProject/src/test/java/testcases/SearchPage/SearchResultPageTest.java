package testcases.SearchPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccoutPage;
import pageobjects.SearchResultpage;
import pageobjects.SigninPage;

import static base.BaseClass.getDriver;

public class SearchResultPageTest extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public SearchResultpage SearchResultpage;
    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1,description = "Kiểm tra tìm kiếm sản phẩm thành công")
    public void verifySearchProductWithKeyValid() throws Exception {
        IndexPage = new IndexPage(driver);
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "search");
        SearchResultpage = IndexPage.searchProduct(excel.getCellData("key", 1));
        boolean result = SearchResultpage.isProductAvilable();
        Assert.assertTrue(result);
        System.out.println("verifySearchProductValid : Pass");
    }
}
