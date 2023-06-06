package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//div[@class='product__price ']//span")
    private WebElement unitPrice;
    @FindBy(xpath = "//td[@class='cart_total_amount']//strong")
    private WebElement totalPrice;
    @FindBy(xpath = "//tr[2]//td[@class='cart_total_amount']")
    private WebElement coupoTotal;
    @FindBy(xpath = "//button[normalize-space()='Proceed To CheckOut']")
    private WebElement buttonCheckOut;
    @FindBy(xpath = "//button[normalize-space()='Apply Coupon']")
    private WebElement buttonApplyCoupoCode;
    @FindBy(xpath = "//span[@class='text-danger']")
    private WebElement messageErroCoupoCode;
    @FindBy(xpath = "//input[@placeholder='Enter Coupon Code...']")
    private WebElement inputCoupoCode;
    @FindBy(xpath = "//input[@value='-']")
    private WebElement btnMinus;
    @FindBy(xpath = "//input[@value='+']")
    private WebElement btnPlus;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement messageMaximumQty;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement alertSuccess;
    @FindBy(xpath = "//div[@class='section']//p[@class='text-center'][normalize-space()='Your cart is empty!']")
    private WebElement cartEmpty;
    @FindBy(xpath = "//a[@class='btn-remove-coupon-code text-danger']")
    private WebElement btnRemove;
    @FindBy(xpath = "//i[@class='ti-close']")
    private WebElement btnRemoveProduct;
    @FindBy(xpath = "//div[@class='modal-content']//div[@class='modal-body']")
    private WebElement popupConfirmRemoveProduct;
    @FindBy(xpath = "//span[@aria-hidden='true']")
    private WebElement buttonClose;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement buttonCancel;
    @FindBy(xpath = "//button[normalize-space()='Yes, remove it!']")
    private WebElement buttonConfirm;
    @FindBy(xpath = "//a[@title='Hand playstation']")
    private WebElement productName;
    @FindBy(xpath = "//tr[4]//td[@class='cart_total_amount']//strong")
    private WebElement totalPriceCoupo;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public double getUnitPrice() {
        String unitPrice1 = unitPrice.getText();
        String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double FinalUnitPrice = Double.parseDouble(unit);
        return FinalUnitPrice/100;
    }
    public double getTotalPrice() {
        String totalPrice1 = totalPrice.getText();
        String unit = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double FinalTotalPrice = Double.parseDouble(unit);
        return FinalTotalPrice/100;
    }
    public double getTotalPriceCoupo() {
        String totalPrice1 = totalPriceCoupo.getText();
        String unit = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double FinalTotalPrice = Double.parseDouble(unit);
        return FinalTotalPrice/100;
    }
    public double getTotalCoupo() {
        String totalPrice1 = coupoTotal.getText();
        String unit = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double FinalTotalPrice = Double.parseDouble(unit);
        return FinalTotalPrice/100;
    }
    public void clickOnProcessToCheckOut() {
        buttonCheckOut.click();
//        return new AddressPage(driver);
    }
    public void checkOutButton() {
        buttonCheckOut.isEnabled();
    }
    public void enterCuopoCode(String coupo){
        inputCoupoCode.sendKeys(coupo);
        buttonApplyCoupoCode.click();
    }
    public AddressPage btnApplyCoupoCode() {
        buttonApplyCoupoCode.click();
        return new AddressPage(driver);
    }
    public boolean buttonApplyCoupoCode() {
        return buttonApplyCoupoCode.isSelected();
    }
    public void ErroAoupoCode() {
        messageErroCoupoCode.isDisplayed();
    }
    public boolean minus() {
       return btnMinus.isEnabled();
    }
    public boolean clickPluss() {
        return btnPlus.isEnabled();
    }
    public String successAlert() {
        return alertSuccess.getText();
    }
    public String failAlert() {
        return messageMaximumQty.getText();
    }
    public void cartEmpty() {
        cartEmpty.isDisplayed();
    }
    public void clickButtonRemoveCoupo() {
        btnRemove.click();
    }
    public boolean buttonRemoveCoupoEnable() {
        return btnRemove.isDisplayed();
    }
    public boolean inputCoupo(){
        return inputCoupoCode.isEnabled();
    }
    public void checkPopupRemove() {
        boolean actual1 = btnRemoveProduct.isDisplayed();
        Assert.assertTrue(actual1,"false");
        btnRemoveProduct.click();
        String actual2 = "Are you sure you want to remove this product from cart?";
        Assert.assertEquals(actual2,popupConfirmRemoveProduct.getText());
    }
    public void closePopupRemoveProductInCart() {
        boolean actual1 = btnRemoveProduct.isDisplayed();
        Assert.assertTrue(actual1,"false");
        btnRemoveProduct.click();
        String actual2 = "Are you sure you want to remove this product from cart?";
        Assert.assertEquals(actual2,popupConfirmRemoveProduct.getText());
        buttonCancel.click();
        boolean popup = popupConfirmRemoveProduct.isDisplayed();
        Assert.assertTrue(popup,"False");
    }
    public void removeProductInCart() {
        btnRemoveProduct.click();
        buttonConfirm.click();
        boolean check = cartEmpty.isDisplayed();
        Assert.assertTrue(check,"Sản phẩm vẫn tồn tại xóa không được");
    }
    public String titlePage() {
        return driver.getTitle();
    }

}
