package pageobjects;

import base.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
    private WebDriver driver;
    //Resset password page (Forgot Password)
    WebDriverWait wait;
    public ValidateHelper ValidateHelper;

    @FindBy(xpath = "//h1[normalize-space()='Reset Password']")
    private WebElement headerPageResetPasswordTitle;
    @FindBy(xpath = "//input[@id='txt-email']")
    private WebElement InputEmailReset;
    @FindBy(xpath = "//button[normalize-space()='Send Password Reset Link']")
    private WebElement ButtonSendRessetEmail;
    @FindBy(xpath = "//div[@class='text-success']")
    private WebElement textSuccess;
    public ForgotPassword(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public void ForgotPass(String email) {
        ValidateHelper = new ValidateHelper(driver);
        ValidateHelper.setText(InputEmailReset,email);
        ValidateHelper.clickElement(ButtonSendRessetEmail);
    }
    public String checkForgotPassWord() {
        return textSuccess.getText();
    }

}
