package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class productListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //list select
    @FindBy(xpath = "//select[@id='sort-by']")
    private WebElement sortBy;
    @FindBy(className = "grid")
    private WebElement grid;
    @FindBy(className = "list")
    private WebElement list;
    @FindBy(xpath = "//select[@name='num']")
    private WebElement numberProduct;

    @FindBy (xpath = "//h5[normalize-space()='Product Categories']")
    private WebElement titleCategories;
    @FindBy(how= How.XPATH,using="//ul[@class='ps-list--categories']/li")
    private List<WebElement> listCate;
    @FindBy(how= How.XPATH,using="//li[@class='  menu-item-has-children ']")
    private List<WebElement> listCatePlus;

    @FindBy (xpath = "//h5[normalize-space()='Brands']")
    private WebElement titleBrand;

    @FindBy (xpath = "//h5[normalize-space()='Product Tags']")
    private WebElement titleProductTag;
    @FindBy (xpath = "//h5[normalize-space()='By Price']")
    private WebElement titleByPrice;
    @FindBy (xpath = "//h4[normalize-space()='By Color']")
    private WebElement titleColor;
    @FindBy (xpath = "//ul[@class='pagination']")
    private WebElement pageNavigation;

    @FindBy(how= How.XPATH,using="//div[@id='mCSB_1_container']/li")
    private List<WebElement> listBrand;
    @FindBy(how= How.XPATH,using="//div[@id='mCSB_2_container']/li")
    private List<WebElement> listProductTag;
    @FindBy(how= How.XPATH,using="//ul[@class='visual-swatch color-swatch']/li")
    private List<WebElement> listColor;
    @FindBy(how= How.XPATH,using="//ul[@class='pagination']/li")
    private List<WebElement> listNavigation;

    public productListPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public String getCurrenURL() {
        String currenURL = driver.getCurrentUrl();
        return currenURL;
    }
    public void listProductCate(String listcate) {
        System.out.println(listCate.size());
        String array[] = new String[listCate.size()];
        for (int i = 1; i <= listCate.size(); i++) {
            WebElement product = driver.findElement(By.xpath("//ul[@class='ps-list--categories']/li["+i+"]//a"));
            array[i] = product.getText();
            System.out.println(array[i]);
            if (array[i].contains(listcate)) {
                product.click();
                break;
            }
        }
    }
}
