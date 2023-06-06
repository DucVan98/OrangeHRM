package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//input[@title='Qty']")
    private WebElement quanlitys;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//h4[contains(@class,'product_title')]//a")
    private WebElement productName;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement alertSuccess;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement messageMaximumQty;
    //alert alert-danger alert-dismissible : status nập quá số lượng

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public void enterQuality(String number) {
        quanlitys.clear();
        quanlitys.sendKeys(number);
    }
    public String getProductName(){
       return productName.getText();
    }
    // kiem tra thong bao them san pham vao cart thành công
    public boolean checkAlert() {
        alertSuccess.isEnabled();
        String getVerifyAddtocartText = alertSuccess.getText();
        boolean averifyText = getVerifyAddtocartText.contains("to cart successfully!");
        System.out.println(averifyText);
        return averifyText;
    }
    public boolean checkAlertFail() {
        return messageMaximumQty.isEnabled();
    }
//    The qty must be an integer.
    // kiem tra loi khi nhap so luong > 10 item
    public boolean CheckMessageMaximumQty() {
        return messageMaximumQty.isEnabled();
    }
    public CartPage clickAddToCart(){
        addToCartButton.click();
        return new CartPage(driver);
    }

}
