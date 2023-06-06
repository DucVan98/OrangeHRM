package pageobjects;

import base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelper validate;
//    private WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
//    private WebElement element = driver.switchTo().activeElement();
    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//label[normalize-space()='Bank transfer']")
    private WebElement checkboxBank;
    @FindBy(xpath = "//label[normalize-space()='Cash on delivery (COD)']")
    private WebElement checkboxCOD;
    @FindBy(xpath = "//a[normalize-space()='You have a coupon code?']")
    private WebElement addCoupoCode;
    @FindBy(xpath = "//input[@placeholder='Enter coupon code...']")
    private WebElement inputCoupoCode;
    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement buttonApplyCoupoCode;
    @FindBy(xpath = "//select[@id='address_id']")
    private WebElement addressID;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement LoginButton1;

    //input address by guest

    @FindBy(xpath = "//input[@id='address_name']")
    private WebElement fullName;

    @FindBy(xpath = "//input[@id='address_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='address_phone']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//label[@for='shipping-method-default-1']")
    private WebElement shippingMethod;


    @FindBy(id = "address_country")
    private WebElement Country;

    @FindBy(xpath = "//input[@id='address_state']")
    private WebElement state;
    @FindBy(xpath = "//input[@id='address_city']")
    private WebElement cityField;
    @FindBy(xpath = "//input[@id='address_address']")
    private WebElement address;
    @FindBy(xpath = "//input[@id='create_account']")
    private WebElement checkboxCreateAccount;
    //input[@id='password']
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPass;
    @FindBy(xpath = "//input[@id='password-confirm']")
    private WebElement inputRePass;
    public AddressPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public void clickCheckOut() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkoutButton);
    }
    public void clickButtonBank() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkboxBank);
//        checkboxBank.click();
    }
    public void clickButtonCOD() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkboxCOD);
//        checkboxCOD.click();
    }
    public void clickShippingMethod() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", shippingMethod);
//        shippingMethod.click();
    }
    public boolean checkAddCoupoCode() {
        return addCoupoCode.isDisplayed();

    }
    public void clickAddCoupoCode() {
        addCoupoCode.click();
    }
    public void clickInputCoupeCode(String coupoCode) {
        inputCoupoCode.click();
        inputCoupoCode.clear();
        inputCoupoCode.sendKeys(coupoCode);
    }
    public void signIn(){
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) LoginButton1));
        Actions actions = new Actions(driver);
        actions.moveToElement(LoginButton1).click().perform();

//        LoginButton1.click();
//        return new SigninPage(driver);
    }
//guest checkout
    public void setFullName(String fullname) {
        fullName.sendKeys(fullname);
    }
    public void setEmail(String email) {
        emailField.sendKeys(email);
    }
    public void setPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    public void selectCountry(String value) {
        Select select = new Select(Country);
        select.selectByVisibleText(value);
    }
    public void setState(String st) {
        state.sendKeys(st);
    }
    public void setCity(String city) {
        cityField.sendKeys(city);
    }
    public void setAddress(String Address) {
        address.sendKeys(Address);
    }
    public void clickCheckBoxCreateAccount(){
        checkboxCreateAccount.click();
    }
    public void accoutNew(String pass, String rePass) {
        inputPass.sendKeys(pass);
        inputRePass.sendKeys(rePass);
    }

    public void geustCheckOutGeust(String fullname,
                                   String mail,
                                   String phone,
                                   String country,
                                   String st,
                                   String city,
                                   String Address) {
        Select select = new Select(Country);
        fullName.sendKeys(fullname);
        emailField.sendKeys(mail);
        phoneNumber.sendKeys(phone);
        select.selectByVisibleText(country);
        state.sendKeys(st);
        cityField.sendKeys(city);
        address.sendKeys(Address);
    }
}
