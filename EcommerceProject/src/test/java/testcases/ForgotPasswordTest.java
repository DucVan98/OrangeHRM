package testcases;

import base.BaseClass;
import helpers.ExcelHelpers;
import utils.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.ForgotPassword;
import pageobjects.IndexPage;
import pageobjects.SigninPage;

//@Listeners(TestListener.class)
public class ForgotPasswordTest extends BaseClass {
    private WebDriver driver;
    public ForgotPassword ForgotPassword;
    public IndexPage IndexPage;
    public SigninPage SigninPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }
    @Test(priority = 1, description = "Kiểm tra tính năng quên mật khẩu")
    public void ForgotPassWord() throws Exception {
        ForgotPassword = new ForgotPassword(driver);
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ForgotPassword = SigninPage.clickForgotPass();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        ForgotPassword.ForgotPass(excel.getCellData("Email",1));
        String result = ForgotPassword.checkForgotPassWord();
        String expected = "We have emailed your password reset link!";
        Assert.assertEquals(result,expected);
        System.out.println("ForgotPassWord : Pass");

    }
}
