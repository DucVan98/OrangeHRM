package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummary {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//h3[normalize-space()='Your order is successfully placed']")
    private WebElement orderSuccess;

    public OrderSummary(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }
    public String verifyOrderSuccess() {
        String confirmMSG = orderSuccess.getText();
        return confirmMSG;
    }

}
