package pageobjects;

import actiondriver.Action;
import com.sun.xml.internal.ws.api.server.WSWebServiceContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ValidateHelper;
import org.testng.Assert;
import org.testng.mustache.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexPage  {
    private WebDriver driver;

    //SignUp page
    WebDriverWait wait;

    @FindBy(xpath = "//a//span[normalize-space()='Login']")
    private WebElement ButtonLogin;
    @FindBy(xpath = "//img[@class='logo_dark']")
    private WebElement logo;
    @FindBy(xpath = "//select[@name='categories[]']")
    private WebElement filterCategories;
    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement searchProductBox;
    @FindBy(xpath = "//button[@class='search_btn']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[contains(@class,'d-flex align-items-center justify-content-center justify-content-md-end')]//li[1]//a[1]")
    private WebElement accountInformation;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/h6[1]")
    private WebElement selectedProduct;
    @FindBy(xpath = "//a[@class='nav-link cart_trigger btn-shopping-cart']")
    private WebElement clickShowCart;
    @FindBy(xpath = "//a[normalize-space()='View Cart']")
    private WebElement clickViewCart;
    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    private WebElement buttonCheckOut;
    @FindBy(xpath = "//div[@class='cart_box dropdown-menu dropdown-menu-right show']//p[@class='text-center']")
    private WebElement verifyCartEmty;
    @FindBy(xpath = "//span[normalize-space()='Logout']")
    private  WebElement buttonLogout;
    @FindBy(xpath = "//i[@class='ti-user']")
    private WebElement buttonUserAccout;
    @FindBy(xpath = "//span[@class='cart_count']")
    private WebElement cartCout;

    @FindBy(xpath = "//div[@class='carousel-inner']")
    private WebElement slider;

    ///categories locator///

    @FindBy(xpath = "//h2[normalize-space()='Top Categories']")
    private WebElement topCategories;

    @FindBy(how= How.XPATH,using="//div[@class='cat_slider cat_style1 mt-4 mt-md-0 carousel_slider owl-carousel owl-theme nav_style5 owl-loaded owl-drag']//div[@class='owl-item']")
    private List<WebElement> listTopCategories;

    // Exclusive Products locatoer//
    @FindBy(xpath = "//h4[normalize-space()='Exclusive Products']")
    private WebElement exclusiveProductTitle;
    @FindBy(xpath = "//a[@id='new-arrival-tab']")
    private WebElement newArrivalTab;
    @FindBy(xpath = "//a[@id='best-sellers-tab']")
    private WebElement bestSellersTab;
    @FindBy(xpath = "//a[@id='special-offer-tab']")
    private WebElement specialOfferTab;
    @FindBy(xpath = "//div[@class='section small_pt pb-0']//div[@class='owl-dots']//button[1]")
    private WebElement nextExcludive;
    @FindBy (xpath = "(//a[contains(text(),'Macbook Pro 13 inch')])[1]")
    private WebElement newArrivalProduct;
//list categori//
    @FindBy(xpath = "(//a[@class='hover_effect1'])[1]")
    private WebElement headPhone;
    @FindBy(xpath = "//*[@id='app']/div/div[4]/div/div/div[2]/div/a")
    private WebElement camera;
    @FindBy(xpath = "//*[@id='app']/div/div[4]/div/div/div[3]/div/a")
    private WebElement watch;


    //Trending Products//
    @FindBy(xpath = "//h4[normalize-space()='Trending Products']")
    private WebElement trendingProducts;
    @FindBy(xpath = "//div[@class='section small_pt small_pb']//span[contains(text(),'View All')]")
    private WebElement viewAllTrendingProducts;
    @FindBy(xpath = "//div[@class='section small_pt small_pb']//div[@class='owl-dots']//button[1]")
    private WebElement nextTrendingProduct;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='ck-content']/div[@class='section small_pt small_pb']/div[@class='container']/div[@class='row']/div[@class='col-12']/div[@class='product_slider carousel_slider owl-carousel owl-theme dot_style1 owl-loaded owl-drag']/div[@class='owl-stage-outer']/div[@class='owl-stage']")
    private WebElement verifyProduct;
//    @FindBy (xpath = "//div[@class='section small_pt small_pb']//div[6]")
    @FindBy(how= How.XPATH,using="//div[@class='section small_pt small_pb']//div[@class='owl-item']")
    private List<WebElement> listTrendingProduct;

    //Featured Products

    @FindBy(xpath = "//h4[normalize-space()='Featured Products']")
    private WebElement featuredProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/span[1]")
    private WebElement viewAllFeaturedProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement listFeaturedProduct;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[2]")
    private WebElement nextListFeaturedProduct;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]")
    private WebElement preListFeaturedProduct;

//    Top Rated Products
    @FindBy(xpath = "//h4[normalize-space()='Top Rated Products']")
    private WebElement TopRatedProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]/span[1]")
    private WebElement viewAllTopRatedProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
    private WebElement listTopRatedProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button[2]")
    private WebElement nextListTopRatedProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]")
    private WebElement preListTopRatedProducts;

    //On Sale Products
    @FindBy(xpath = "//h4[normalize-space()='On Sale Products']")
    private WebElement onSaleProducts;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[6]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/a[1]/span[1]")
    private WebElement viewAllonSaleProducts;
    @FindBy(xpath = "//h4[normalize-space()='Our Brands']")
    private WebElement ourBrands;

    @FindBy (xpath = "//h2[normalize-space()='Visit Our Blog']")
    private WebElement visitOurBlog;
    @FindBy (xpath = "//h2[normalize-space()='Our Client Say!']")
    private WebElement ourClientSay;
    @FindBy (xpath = "//h3[normalize-space()='Join Our Newsletter Now']")
            private WebElement newLetter;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]")
            private WebElement productWatch;
    @FindBy(xpath = "//a[@class='add-to-cart-button active']//i[@class='icon-basket-loaded']")
    private WebElement addtoCartButton;




    //menu
    @FindBy(xpath = "//a[normalize-space()='Products']")
    private WebElement productButton;


    Action action= new Action();

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public SigninPage clickOnSignIn() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ButtonLogin.click();
        return new SigninPage(driver);
    }
    public productListPage clickProductInMenu() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        productButton.click();
        return new productListPage(driver);
    }

    public boolean validateLogo() {
        return logo.isDisplayed();
    }
    public String getUrl() {
       return driver.getCurrentUrl();
    }
    public void clickMyAccountButton() {
        Assert.assertTrue(buttonUserAccout.isDisplayed());
        buttonUserAccout.click();
    }
    public boolean verifyLogin() throws InterruptedException {
        Thread.sleep(1000);
        return buttonLogout.isEnabled();
    }
    public SearchResultpage searchProduct(String productName) {
        searchProductBox.click();
        ValidateHelper.setText(searchProductBox, productName);
        searchButton.click();
        System.out.println("Search ok!");
        return new SearchResultpage(driver);
    }
    public MyAccoutPage gotoAccountInfo(){
        ValidateHelper.clickElement(accountInformation);
        return new MyAccoutPage(driver);
    }
    public boolean VerifyCartEmty() {
        return verifyCartEmty.isEnabled();
//        return true;
    }
    public void validateAddtocart() {
        cartCout.getText();
    }
    public void selectProduct(){
        selectedProduct.click();
    }
    public void clickShowCart() {

        clickShowCart.click();

    }
    //ham viết cho case checkout chưa login tài khoản
    public SigninPage clickCheckOut() {
        buttonCheckOut.click();
        return new SigninPage(driver);
    }
    public void clickViewCart() {
        Assert.assertTrue(clickViewCart.isEnabled());
        clickViewCart.click();
    }
    public String getCurrenURL() {
        String homeCurrenURL = driver.getCurrentUrl();
        return homeCurrenURL;
    }
    ///categories locator///
//    private String scollToElement(Value element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
////        return element;
//    }

    public boolean slider() {
        return slider.isDisplayed();
    }
    public String TopCategories() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", topCategories);
        String topCategoriesText = topCategories.getText();
        return topCategoriesText;
    }
//    Exclusive Products
    public String ExclusiveProducts() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", exclusiveProductTitle);
        String exclusiveProductsText = exclusiveProductTitle.getText();
        return exclusiveProductsText;
    }
    public String NewArrival() {
        newArrivalTab.click();
        return newArrivalProduct.getText();
    }
    public void cateHeadphone() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", headPhone);
        headPhone.click();
    }
    public void cateCamera() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", camera);
//        ValidateHelper.scollToElement(camera);
        camera.click();
    }
    public void cateWatch() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", watch);
        watch.click();
    }
    public String trendingProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", trendingProducts);
        return trendingProducts.getText();
    }
    public void getListProduct() {
        productWatch.click();
    }
    public String featuredProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", featuredProducts);
        return featuredProducts.getText();
    }
    public String topRetedProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", TopRatedProducts);
        return TopRatedProducts.getText();
    }
    public String onSaleProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", onSaleProducts);
        return onSaleProducts.getText();
    }
    public void byProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", topCategories);
        Actions action = new Actions(driver);
        action.moveToElement(productWatch).build().perform();
        boolean checkEnable = addtoCartButton.isDisplayed();
        if (checkEnable==true) {
            addtoCartButton.click();
            System.out.println("ok");
        }
    }



}
