package pageobjects;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class SearchResultpage {
    private WebDriver driver;
    WebDriverWait wait;
    public SearchResultpage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(how= How.XPATH,using="//div[@class='col-md-4 col-6']")
    private List<WebElement> listProducts;
    @FindBy(xpath="//div[@class='col-md-4 col-6']")
    private WebElement productResult;
    @FindBy (xpath ="//div[contains(text(),'No products!')]")
    private WebElement noProduct;
    public AddToCartPage clickOnProduct(String productName) {
        System.out.println("check add to cart");
        String array[] = new String[listProducts.size()];
        for (int i = 1; i <= listProducts.size(); i++) {
            WebElement product = driver.findElement(By.xpath("//div[@class='col-md-4 col-6'][" + i + "]//div[@class='product']//div[@class='product_info']//h6[@class='product_title']//a"));
            array[i] = product.getText();
            if (array[i].contains(productName)) {
                product.click();
                break;
            }
        }
        return new AddToCartPage(driver);
    }
    public boolean isProductAvilable() {
        return productResult.isDisplayed();
    }
    public boolean isNoProductAvilable() {
        return noProduct.isDisplayed();
    }
}
