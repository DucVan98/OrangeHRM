package testcases.CartPage;

import base.BaseClass;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;
import testcases.AddToCart.AddToCartContractor;

public class CartContractor extends BaseClass {
    private WebDriver driver;
    public pageobjects.SigninPage SigninPage;
    public pageobjects.IndexPage IndexPage;
    public pageobjects.MyAccoutPage MyAccoutPage;
    public pageobjects.SearchResultpage SearchResultpage;
    public pageobjects.AddToCartPage AddToCartPage;
    public CartPage CartPage;
    public AddToCartContractor addToCart;

    public CartContractor(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public void verifyTotalPrice() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        addToCart = new AddToCartContractor(driver);
        addToCart.AddToCartTest();
        IndexPage.clickShowCart();
        Thread.sleep(1000);
        IndexPage.clickViewCart();
        Thread.sleep(1000);
        Double unitPrice = CartPage.getUnitPrice();
        Double totalPrice =CartPage.getTotalPrice();
        Double tax = ((unitPrice*2)/100)*10;
        Double expected =(unitPrice*2)+tax;
        Assert.assertEquals(expected,totalPrice,"ok");
    }
    public void VeriFyCoupoCode() throws Exception {
        IndexPage = new IndexPage(driver);
        CartPage = new CartPage(driver);
        addToCart = new AddToCartContractor(driver);
        addToCart.AddToCartTest();
        IndexPage.clickShowCart();
        Thread.sleep(1000);
        IndexPage.clickViewCart();
        Thread.sleep(1000);
        Scoll(0,400);
        CartPage.enterCuopoCode("add");
        Double unitPrice = CartPage.getUnitPrice();
        Double totalPrice =CartPage.getTotalPriceCoupo();
        Double totalCoupo =CartPage.getTotalCoupo();
        Double tax = ((unitPrice*2)/100)*10;
        Double expected =(unitPrice*2)+tax-totalCoupo;
        Assert.assertEquals(expected,totalPrice,"Fail");
    }
}
