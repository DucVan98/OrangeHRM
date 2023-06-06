package testcases.SignInPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.ForgotPassword;
import pageobjects.IndexPage;
import pageobjects.MyAccoutPage;
import pageobjects.SigninPage;

public class signContractor extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.ForgotPassword ForgotPassword;

    public signContractor(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
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
        Assert.assertNotEquals(expectURL,actual);
        System.out.println("Login success! : Pass");
    }
    public void signInFirst() throws Exception {
        SigninPage = new SigninPage(driver);
        IndexPage = new IndexPage(driver);
        SigninPage=IndexPage.clickOnSignIn();
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile("src/test/resources/TestData/Book2.xlsx", "account");
        Scoll(0,50);
        Thread.sleep(1000);
        IndexPage = SigninPage.signingHome(excel.getCellData("Email", 2), excel.getCellData("Password", 2));
//        IndexPage = SigninPage.signingHome("john.smith@botble.com","12345678");
        String actual =IndexPage.getCurrenURL();
        String expectURL = "http://localhost/orangehrm/public/";
        Assert.assertNotEquals(expectURL,actual);
        System.out.println("Login success! : Pass");
    }

}
