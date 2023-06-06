package testcases.SearchPage;

import base.BaseClass;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.SkipException;
import utils.listeners.TestListener;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.IndexPage;

//@Listeners(TestListener.class)
public class SearchResultFailTest extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1, description = "")
    public void verifyTestCaseSkip() throws Exception {
        throw new SkipException("Kiểm tra tính năng dừng không check testcase này nữa");
    }
    @Test(priority = 2,description = "Kiểm tra tìm kiếm với từ khóa không hợp lệ hoặc không có sản phẩm phù hợp với từ khóa tìm kiếm")
    public void verifySearchProductWithKeyInvalid() throws Exception {
        IndexPage = new IndexPage(driver);
        SearchResultpage = IndexPage.searchProduct("@@@@");
        boolean result = SearchResultpage.isNoProductAvilable();
        Assert.assertTrue(result);
    }
}
