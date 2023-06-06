package base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class ValidateHelper {
    private static WebDriver driver;

    private static WebDriverWait wait;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyPageTitle(String pageTitle) {
        return getPageTitle().contains(pageTitle);
    }

    // Hôm nay rảnh quá viết dc 2 hàm chung: sendKeys chung và click chung
    public static void setText(WebElement element, String valueText) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(valueText);
    }
    public static void scollToElement(WebElement element) {
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void clickElement(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
