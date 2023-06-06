package base;

import helpers.ScreenShortHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.helpers.CaptureHelpers;
//import utility.ExtentManager;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private static WebDriver driver;
    public static Properties prop;
    static String driverPath = "resources\\driver\\";
//    public static ScreenShortHelpers ScreenShortHelpers;

    public static WebDriver getDriver() {
        return driver;
//        ScreenShortHelpers = new ScreenShortHelpers();
    }
//    public void loadConfig() {
////        BoundedRangeModel ExtentManager = null;
//        ExtentManager.setExtent();
//        DOMConfigurator.configure("log4j.xml");
//
//        try {
//            prop = new Properties();
//            FileInputStream ip = new FileInputStream(
//                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
//            prop.load(ip);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void setDriver(String browserType, String appURl) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURl);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURl);
                break;
            default:
                System.out.println("Browser" + browserType + "is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURl);
        }
//        return driver;
    }

    // cấu hình các trình duyệt để đưa vào switch case
    private static WebDriver initFirefoxDriver(String appURl) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURl);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initChromeDriver(String appURl) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURl);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public void Scoll(int left, int right){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+left+","+right+")", "");
    }
    public String getCurrUrl() {
        return driver.getCurrentUrl();
    }

    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
    @Parameters({"browserType", "appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            CaptureHelpers.startRecord("Test");
            // Khởi tạo driver và browser
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.SUCCESS == result.getStatus()) {
            try {
                ScreenShortHelpers.captureScreenshot(driver, result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        System.out.println("quit");
        driver.quit();
        CaptureHelpers.stopRecord();
    }
}
