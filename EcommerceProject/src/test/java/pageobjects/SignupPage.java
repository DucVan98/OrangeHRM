package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupPage {
    private WebDriver driver;
    //SignUp page
    WebDriverWait wait;

    @FindBy(xpath = "(//div[@class='page-title'])[1]")
    private WebElement headerPageSignUpTitle;
    @FindBy(xpath ="//input[@id='txt-name']")
    private WebElement InputUserName;
    @FindBy(xpath = "//input[@id='txt-email']")
    private WebElement InputSignUpEmail;
    @FindBy(xpath = "//input[@id='txt-password']")
    private WebElement InputSignUpPassword;
    @FindBy(xpath = "//input[@id='txt-password-confirmation']")
    private WebElement InputRePassword;
    @FindBy(xpath = "//div[@class='custome-checkbox']//label[@for='terms-policy']")
    private WebElement CheckboxConfirm;
    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    private WebElement ButtonSignUp;
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    private WebElement ButtonLogin;
    @FindBy(xpath = "//form[@method='POST']//div[1]//span[@class='text-danger']")
    private WebElement ErrorMsgTextUser;
    @FindBy(xpath = "//form[@method='POST']//div[2]//span[@class='text-danger']")
    private WebElement ErrorMsgText;
    @FindBy(xpath = "//form[@method='POST']//div[3]//span[@class='text-danger']")
    private WebElement ErroMsgTextPassword;
    @FindBy(xpath = "//div[@class='login_footer form-group']")
    private WebElement ErroMsgTextLoginFoodter;
    public SignupPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public IndexPage createAccount(String User, String email, String password, String rePassword) throws InterruptedException {
//        Assert.assertTrue(getHeader(),"Header");
        setText(InputUserName,User);
        setText(InputSignUpEmail,email);
        setText(InputSignUpPassword, password);
        setText(InputRePassword,rePassword);
        Thread.sleep(1000);
        clickCheckbox();
        ButtonSignUp.click();
        return new IndexPage(driver);
    }
    //Hôm nay rảnh quá viết dc 2 hàm chung: sendKeys chung và click chung
    public void setText(WebElement element, String valueText) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(valueText);
    }
    public void clickCheckbox(){
//        WebElement checkbox = driver.findElement(ButtonLogin);
        Assert.assertTrue(CheckboxConfirm.isDisplayed(),"Khong tim thay duong dan den element nay");
        CheckboxConfirm.click();
    }
    public void clearButton() {
        InputUserName.clear();
        InputSignUpEmail.clear();
        InputRePassword.clear();
        InputSignUpPassword.clear();
//        clickCheckbox();
    }

    public void clickElement(WebElement element) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public String getHeader(){
        String pageTitle = headerPageSignUpTitle.getText();
        return pageTitle;
    }
    public String getErrorMsgTextUser(){
        String strErrorMsg = null;
        if (ErrorMsgTextUser.isDisplayed() && ErrorMsgTextUser.isEnabled())
            strErrorMsg = ErrorMsgTextUser.getText();
        return strErrorMsg;
    }
    public String getErrorMsgText(){
        String strErrorMsg = null;
        if (ErrorMsgText.isDisplayed() && ErrorMsgText.isEnabled())
            strErrorMsg = ErrorMsgText.getText();
        return strErrorMsg;
    }
    public String getErroMsgTextPassword(){
        String strErrorMsg = null;
        if (ErroMsgTextPassword.isDisplayed() && ErroMsgTextPassword.isEnabled())
            strErrorMsg = ErroMsgTextPassword.getText();
        return strErrorMsg;
    }
    public String getErroMsgTextLoginFoodter(){
        String strErrorMsg = null;
        if (ErroMsgTextLoginFoodter.isDisplayed() && ErroMsgTextLoginFoodter.isEnabled())
            strErrorMsg = ErroMsgTextLoginFoodter.getText();
        return strErrorMsg;
    }
}
