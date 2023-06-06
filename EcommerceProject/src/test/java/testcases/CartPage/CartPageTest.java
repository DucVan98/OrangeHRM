package testcases.CartPage;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.AddToCart.AddToCartContractor;
import testcases.AddToCart.AddToCartPageTest;
import testcases.SearchPage.SearchResultPageTest;
import utils.listeners.TestListener;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;
//@Listeners(TestListener.class)
public class CartPageTest extends BaseClass {
    private WebDriver driver;
    public SigninPage SigninPage;
    public IndexPage IndexPage;
    public MyAccoutPage MyAccoutPage;
    public SearchResultpage SearchResultpage;
    public AddToCartPage AddToCartPage;
    public CartPage CartPage;
    public AddToCartContractor addToCart;

//    public CartPageTest(WebDriver driver) {
//        this.driver = driver;
//        WebDriverWait wait = new WebDriverWait(this.driver, 5);
//        PageFactory.initElements(this.driver, this);
//    }


    @BeforeClass
    public void setUp() {
        driver = getDriver();
        ExcelHelpers excel = new ExcelHelpers();

    }
    @Test (priority = 1, description = "Kểm tra sản phẩm trong giỏ hàng có đúng hay không")
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
    @Test(priority = 2 , description = "Kiểm tra tính năng xóa sản phẩm khỏi giỏ hàng")
    public void DeleteProductToCart() throws Exception {
        CartPage.removeProductInCart();
    }


}
