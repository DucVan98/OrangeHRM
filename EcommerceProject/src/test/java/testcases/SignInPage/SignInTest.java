package testcases.SignInPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.MyAccoutPage;
import pageobjects.SigninPage;
import pageobjects.ForgotPassword;

//@Listeners(TestListener.class)
//@Listeners(ReportListener.class)
public class SignInTest extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public ForgotPassword ForgotPassword;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1)
    public void verifySignInPage() throws InterruptedException {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        String actual = IndexPage.getUrl();
        String expect = "http://localhost/orangehrm/public/login";
        Assert.assertEquals(actual,expect);
        System.out.println("verifySignInPage : Pass");
    }

    // login thành công
    @Test (priority = 2)
    public void signInPage() throws Exception {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome(excel.getCellData("Email", 1), excel.getCellData("Password", 1));
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(actual,expectURL);
        System.out.println("Login success! : Pass");
    }

}
