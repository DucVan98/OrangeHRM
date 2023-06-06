package pageobjects;

import base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SigninPage {
    private WebDriver driver;
    //SignUp page
    public WebDriverWait wait;
//    public ValidateHelper validateHelper;
    public IndexPage IndexPage;
    //Login page
    @FindBy(xpath ="//input[@id='txt-email']")
    private WebElement InputEmail;
    @FindBy(xpath="//input[@id='txt-password']")
    private WebElement InputPassword;
//    private WebElement InputPassword;
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerPageLoginTitle;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    private WebElement ButtonLogin;
    @FindBy(xpath = "//a[normalize-space()='Sign up now']")
    private WebElement SignUpNow;
    @FindBy(xpath = "//a[normalize-space()='Forgot password?']")
    private WebElement ForgotPassword;
    @FindBy(xpath = "//span[normalize-space()='Remember me']")
    private WebElement ButtonRememberMe;
    @FindBy(xpath = "//form[@method='POST']//div[1]//span[@class='text-danger']")
    private WebElement ErrorMsgText;
//    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
//    private WebElement ErrorMsgText;
    //The email field is required.
    @FindBy(xpath = "//form[@method='POST']//div[2]//span[@class='text-danger']")
    private WebElement ErroMsgTextPassword;
    //The password field is required.



    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // class này đọc
    public SigninPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public IndexPage signingHome(String email, String password) throws Exception {
        ValidateHelper.setText(InputEmail,email);
        ValidateHelper.setText(InputPassword,password);
        ButtonRememberMe.click();
        Thread.sleep(1000);
        ButtonLogin.click();
        return new IndexPage(driver);
    }
    public void EnterEmailPassword(String email, String password) throws Exception {
        ValidateHelper.setText(InputEmail,email);
        ValidateHelper.setText(InputPassword,password);
        ButtonLogin.click();
    }
    public AddressPage signinCheckOut(String email, String password) throws Exception {
        setText(InputEmail,email);
        setText(InputPassword,password);
        ButtonRememberMe.click();
        Thread.sleep(1000);
        ButtonLogin.click();
        return new AddressPage(driver);
    }
    public void setText(WebElement element, String valueText) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(valueText);
    }
    public String getPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
//kiểm tra xem co 1 cái tên là login trong này hay không
    public boolean verifyPageTitle() {
//        WebElement expectedTitle =driver.findElement(headerPageLoginTitle);
        String pageTitle = headerPageLoginTitle.getText();
        String expectedPageTitle = "Login";
        return pageTitle.contains(expectedPageTitle);
    }
    // Sau khi thực hiện click Submit thì khởi tạo trang DashboardPage

    public boolean verifySignInFailEmail() {
        return getErrorMessage().contains("These credentials do not match our records.");
    }
    public boolean verifySignInNull() {
        return getErrorMessage().contains("The email field is required.");
    }
    public boolean verifySignInPassFail() {
        return getErrorMessagePassword().contains("The password field is required.");
    }

//    public void ClickRemberme() {
////        WebElement Rememberme = driver.findElement(ButtonRememberMe);
//        Assert.assertFalse(ButtonRememberMe.isSelected(), "Da duoc chon roi");
//        ButtonRememberMe.click();
//    }

    public void clickSignIn() {
//        WebElement signin = driver.findElement(ButtonLogin);
        Assert.assertTrue(ButtonLogin.isDisplayed(),"Khong tim thay duong dan den element nay");
        ButtonLogin.click();
    }

    public void enterEmail(String email) {
        System.out.println("ok e");

//        WebElement Email = driver.findElement(InputEmail);
//        Assert.assertTrue(InputEmail.isDisplayed(),"Khong tim thay duong dan den element nay");
//        Email.click();
//        InputEmail.sendKeys(email);
    }

//    public void enterPassword(String password) {
//        WebElement Password = driver.findElement(InputPassword);
//        System.out.println("ok");
////        Assert.assertTrue(InputPassword.isDisplayed(),"Khong tim thay duong dan den element nay");
////        Email.click();
//        Password.sendKeys(password);
//    }
    private String getErrorMessage(){
        String strErrorMsg = null;
        if (ErrorMsgText.isDisplayed() && ErrorMsgText.isEnabled())
            strErrorMsg = ErrorMsgText.getText();
        return strErrorMsg;
    }
    private String getErrorMessagePassword(){
        String strErrorMsg = null;
        if (ErroMsgTextPassword.isDisplayed() && ErroMsgTextPassword.isEnabled())
            strErrorMsg = ErroMsgTextPassword.getText();
        return strErrorMsg;
    }

    public ForgotPassword clickForgotPass() {
//        WebElement forgotpass = driver.findElement(ForgotPassword);
        Assert.assertTrue(ForgotPassword.isDisplayed(),"Click Forgot Password fail, vui lòng check lại duong dan!!!");
        ForgotPassword.click();
        return new ForgotPassword(driver);
    }
    public SignupPage clickSignUp() {
//        WebElement signUp = driver.findElement(SignUpNow);
        Assert.assertTrue(SignUpNow.isDisplayed(),"Click signup Fail, vui long check lai duong dan!!!");
        SignUpNow.click();
        return new SignupPage(driver);
    }
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}
