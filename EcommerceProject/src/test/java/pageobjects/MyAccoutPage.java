package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccoutPage {
    private WebDriver driver;
    //SignUp page
    WebDriverWait wait;
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    private WebElement ListOrders;
    @FindBy(xpath = "//a[normalize-space()='Account details']")
    private WebElement AccountDetail;
    @FindBy(xpath = "//a[normalize-space()='Downloads']")
    private WebElement Downloads;
    @FindBy(xpath = "//a[normalize-space()='Order return requests']")
    private WebElement OrderReturnRequest;
    @FindBy(xpath = "//a[normalize-space()='My Addresses']")
    private WebElement MyAddresses;
    @FindBy(xpath = "//a[normalize-space()='Change password']")
    private WebElement changePassWord;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logOut;

    public MyAccoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public String getPagetitle() {
        return driver.getTitle();
//        return false;
    }
    public boolean listOrder(){
//        System.out.println(ListOrders.getText());
        return ListOrders.isDisplayed();
    }
    public String gotoListOrderPage() {
        Assert.assertTrue(listOrder());
        return ListOrders.getAttribute("href");
    }
    public boolean accountDetail(){
        return AccountDetail.isDisplayed();
    }
    public String gotoaccountDetailPage() {
//        System.out.println(AccountDetail.getAttribute("href"));

        Assert.assertTrue(accountDetail());
        return AccountDetail.getAttribute("href");
    }
    public boolean downloads(){
        return Downloads.isDisplayed();
    }
    public String gotodownloadsPage() {
        Assert.assertTrue(downloads());
        return Downloads.getAttribute("href");
    }
    public boolean orderReturnRequest(){
        return OrderReturnRequest.isDisplayed();
    }
    public String gotoOrderReturnRequestPage() {
        Assert.assertTrue(orderReturnRequest());
        return OrderReturnRequest.getAttribute("href");
    }
    public boolean ChangePassWord(){
        return changePassWord.isDisplayed();
    }
    public String gotochangePassWordPage() {
        Assert.assertTrue(ChangePassWord());
        return changePassWord.getAttribute("href");
    }
    public boolean MyAddress(){
        return MyAddresses.isDisplayed();
    }
    public String gotoMyAddressPage() {
        Assert.assertTrue(MyAddress());
        return MyAddresses.getAttribute("href");
    }
    public boolean logOut(){
        return logOut.isDisplayed();
    }
    public String gotologOut() {
        Assert.assertTrue(logOut());
        return logOut.getAttribute("href");
    }

}
