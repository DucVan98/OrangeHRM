package testcases.SignInPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.SigninPage;
//@Listeners(TestListener.class)
public class SignInTestErrorCase extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.ForgotPassword ForgotPassword;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();
    }
    // case click button login khi chưa nhập thông tin vào email field và password field
    @Test(priority = 1)
    public void signInEmailNullPassNull() throws Exception {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome("", "");
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(expectURL,actual);
    }
    //Case : kiểm tra nhập đúng email và sai password
    @Test(priority = 2)
    public void signInEmailTruePassFalse() throws Exception {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome(excel.getCellData("Email", 1), "");
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(expectURL,actual);
    }
    // Kiểm tra nhập sai email đúng password
    @Test(priority = 3)
    public void signInEmailFalsePassTrue() throws Exception {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome("nhungpham07@gmail", excel.getCellData("Password",1));
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(expectURL,actual);
//        driver.quit();
    }
    // Kiểm tra nhập sai email và sai password
    @Test(priority = 4)
    public void signInFailEmailFalsePassFalse() throws Exception {
//        driver = getDriver();
//        ExcelHelpers excel = new ExcelHelpers();
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome("nhungpham07@gmail", "0123");
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertEquals(expectURL,actual);
    }

}
