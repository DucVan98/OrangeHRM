package testcases.SingUpPage;

import base.BaseClass;
import utils.listeners.TestListener;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.SigninPage;
import pageobjects.SignupPage;
//@Listeners(TestListener.class)
public class SignupTest extends BaseClass {
    private WebDriver driver;
    public SignupPage SignupPage;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    private ExcelHelpers excel;
    @BeforeClass
    public void setUp() {
        driver = new BaseClass().getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    @Test(priority = 1, description = "Kiểm tra truy cập thành công màn hình đăng ký tài khoản")
    public void verifySignUpPage() throws Exception {
        SigninPage = new SigninPage(driver);
        SignupPage = new SignupPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        Scoll(0,100);
        Thread.sleep(1000);
        SignupPage = SigninPage.clickSignUp();
        String expectedPageTitle = "Sign Up";
        Assert.assertEquals(expectedPageTitle,SignupPage.getHeader(),"fail to check header signup page! Please check again");
        System.out.println("verifySignUpPage : Pass");

    }
    @Test(priority = 2, description = "Kiểm tra đăng ký tài khoản mới thành công")
    public void createNewUserAcount() throws Exception {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        SignupPage = new SignupPage(driver);
        IndexPage = new IndexPage(driver);
        Scoll(0,150);
        Thread.sleep(1000);
        IndexPage = SignupPage.createAccount(excel.getCellData("UserName", 1),excel.getCellData("Email", 1),excel.getCellData("Password",1),excel.getCellData("rePassword",1));
        String actual = IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(actual,expectURL);
    }
}
